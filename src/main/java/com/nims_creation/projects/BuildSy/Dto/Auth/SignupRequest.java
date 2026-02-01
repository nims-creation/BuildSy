package com.nims_creation.projects.BuildSy.Dto.Auth;

public record SignupRequest(
        String email,
        String name,
        String password
) {
}
