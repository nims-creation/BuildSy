package com.nims_creation.projects.BuildSy.Dto.Auth;

public record LoginRequest(
        String email,
        String password
) {
}
