package com.nims_creation.projects.BuildSy.Dto.Auth;

public record UserProfileResponse(
        Long id,
        String email,
        String name,
        String avatarUrl
) {
}

