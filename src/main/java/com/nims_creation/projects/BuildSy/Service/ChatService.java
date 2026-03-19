package com.nims_creation.projects.BuildSy.Service;

import org.springframework.ai.chat.model.ChatResponse;

import java.util.List;

public interface ChatService {
    List<ChatResponse> getProjectChatHistory(Long projectId);
}
