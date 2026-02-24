package com.nims_creation.projects.BuildSy.Dto.Project;

import com.nims_creation.projects.BuildSy.Dto.Auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner
) {
}

