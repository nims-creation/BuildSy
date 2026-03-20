package com.nims_creation.projects.BuildSy.Dto.Chat;

import com.nims_creation.projects.BuildSy.Entity.Enum.ChatEventType;

public record ChatEventResponse(
        Long id,
        ChatEventType chatEventType,
        Integer sequenceOrder,
        String content,
        String filePath,
        String metadata
) {
}
