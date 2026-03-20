package com.nims_creation.projects.BuildSy.Service.Impl;

import com.nims_creation.projects.BuildSy.Entity.ChatSession;
import com.nims_creation.projects.BuildSy.Entity.ChatSessionId;
import com.nims_creation.projects.BuildSy.Entity.Project;
import com.nims_creation.projects.BuildSy.Entity.User;
import com.nims_creation.projects.BuildSy.Error.ResourceNotFoundException;
import com.nims_creation.projects.BuildSy.LLM.Advisors.FileTreeContextAdvisor;
import com.nims_creation.projects.BuildSy.LLM.LlmResponseParser;
import com.nims_creation.projects.BuildSy.LLM.PromptUtils;
import com.nims_creation.projects.BuildSy.LLM.Tools.CodeGenerationTools;
import com.nims_creation.projects.BuildSy.Repository.ChatSessionRepository;
import com.nims_creation.projects.BuildSy.Repository.ProjectRepository;
import com.nims_creation.projects.BuildSy.Repository.UserRepository;
import com.nims_creation.projects.BuildSy.Security.AuthUtil;
import com.nims_creation.projects.BuildSy.Service.AiGenerationService;
import com.nims_creation.projects.BuildSy.Service.ProjectFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Slf4j
public class AiGenerationServiceImpl implements AiGenerationService {

    private final ChatClient chatClient;
    private final AuthUtil authUtil;
    private final ProjectFileService projectFileService;
    private final FileTreeContextAdvisor fileTreeContextAdvisor;
    private final LlmResponseParser llmResponseParser;
    private final ChatSessionRepository chatSessionRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private static final Pattern FILE_TAG_PATTERN = Pattern.compile("<file path=\"([^\"]+)\">(.*?)</file>", Pattern.DOTALL);

    @Override
    @PreAuthorize("@security.canEditProject(#projectId)")
    public Flux<String> streamResponse(String userMessage, Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        createChatSessionIfNotExists(projectId, userId);

        Map<String, Object> adviserParams = Map.of(
                "userid",userId,
                "projectId", projectId
        );

        StringBuilder fullResponseBuffer = new StringBuilder();

        CodeGenerationTools codeGenerationTools = new CodeGenerationTools(projectFileService,projectId);

        return chatClient.prompt()
                .system(PromptUtils.CODE_GENERATION_SYSTEM_PROMPT)
                .user(userMessage)
                .tools(codeGenerationTools)
                .advisors(advisorSpec -> {
                    advisorSpec.params(adviserParams);
                    advisorSpec.advisors(fileTreeContextAdvisor);
                        }
                )
                .stream()
                .chatResponse()
                .doOnNext(response ->{
                    String content = response.getResult().getOutput().getText();
                    fullResponseBuffer.append(content);
                })
                .doOnComplete(()->{
                    Schedulers.boundedElastic().schedule(()->{
                        parseAndSaveFile(fullResponseBuffer.toString(), projectId);
                    });
                })
                .doOnError(error -> log.error("Error during streaming for projectId:{}",projectId))
                .map(response-> Objects.requireNonNull(response.getResult().getOutput().getText()));
    }

    private void finalizeChats(String userMessage, ChatSession chatSession, String fullText, Long projectId){


    }

    private void parseAndSaveFile(String fullResponse, Long projectId) {

        Matcher matcher = FILE_TAG_PATTERN.matcher(fullResponse);

        while(matcher.find()){
            String filePath = matcher.group(1);
            String fileContent = matcher.group(2).trim();
            projectFileService.saveFile(projectId, filePath, fileContent);
        }
    }


    private ChatSession createChatSessionIfNotExists(Long projectId, Long userId){

        ChatSessionId chatSessionId = new ChatSessionId(projectId, userId);
        ChatSession chatSession = chatSessionRepository.findById(chatSessionId).orElse(null);

        if(chatSession == null){
            Project project = projectRepository.findById(projectId)
                    .orElseThrow(()-> new ResourceNotFoundException("Project",projectId.toString()));

            User user = userRepository.findById(userId)
                    .orElseThrow(()-> new ResourceNotFoundException("User",userId.toString()));

            chatSession = ChatSession.builder()
                    .id(chatSessionId)
                    .project(project)
                    .user(user)
                    .build();


            chatSession = chatSessionRepository.save(chatSession);
        }

        return chatSession;
    }
}
