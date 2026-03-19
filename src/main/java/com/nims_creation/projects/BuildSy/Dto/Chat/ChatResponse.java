package com.nims_creation.projects.BuildSy.Dto.Chat;

import com.nims_creation.projects.BuildSy.Entity.ChatEvent;
import com.nims_creation.projects.BuildSy.Entity.ChatSession;
import com.nims_creation.projects.BuildSy.Entity.Enum.MessageRole;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

public record ChatResponse(

        Long id,
        ChatSession chatSession,
        MessageRole role,
        String content,
        List<ChatEvent>events,
        String toolCalls, // JSON Array of Tools Called
        Integer tokensUsed,
        Instant createdAt
) {
}
