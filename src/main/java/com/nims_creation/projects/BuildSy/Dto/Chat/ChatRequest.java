package com.nims_creation.projects.BuildSy.Dto.Chat;

public record ChatRequest(
        String message,
        Long projectId
) {
}
