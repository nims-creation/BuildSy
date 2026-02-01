package com.nims_creation.projects.BuildSy.Dto.Auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {

}


