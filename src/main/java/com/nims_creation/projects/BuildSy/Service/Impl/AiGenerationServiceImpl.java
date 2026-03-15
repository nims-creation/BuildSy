package com.nims_creation.projects.BuildSy.Service.Impl;

import com.nims_creation.projects.BuildSy.Security.AuthUtil;
import com.nims_creation.projects.BuildSy.Service.AiGenerationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class AiGenerationServiceImpl implements AiGenerationService {

    private final ChatClient chatClient;
    private final AuthUtil authUtil;

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

        return chatClient.prompt()
                .system("SYSTEM_PROMPT_HERE")
                .user(userMessage)
                .advisors(advisorSpec -> {
                    advisorSpec.params(adviserParams);
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

    private void parseAndSaveFile(String fullResponse, Long projectId) {
    }


    private void createChatSessionIfNotExists(Long projectId, Long userId){

    }
}
