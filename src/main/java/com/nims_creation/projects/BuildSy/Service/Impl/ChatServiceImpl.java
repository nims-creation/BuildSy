package com.nims_creation.projects.BuildSy.Service.Impl;

import com.nims_creation.projects.BuildSy.Entity.ChatMessage;
import com.nims_creation.projects.BuildSy.Entity.ChatSession;
import com.nims_creation.projects.BuildSy.Entity.ChatSessionId;
import com.nims_creation.projects.BuildSy.Repository.ChatMessageRepository;
import com.nims_creation.projects.BuildSy.Repository.ChatSessionRepository;
import com.nims_creation.projects.BuildSy.Security.AuthUtil;
import com.nims_creation.projects.BuildSy.Service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatSessionRepository chatSessionRepository;
    private final AuthUtil authUtil;

    @Override
    public List<ChatResponse> getProjectChatHistory(Long projectId) {
        Long userId = authUtil.getCurrentUserId();

        ChatSession chatSession = chatSessionRepository.getReferenceById(
                new ChatSessionId(projectId, userId)
        );

        List<ChatMessage> chatMessageList =chatMessageRepository.findByChatSession(chatSession);
        return List.of();
    }
}
