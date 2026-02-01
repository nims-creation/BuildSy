package com.nims_creation.projects.BuildSy.Dto.Auth.Project;

import java.time.Instant;

public record ProjectSummaryResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt
) {
}

