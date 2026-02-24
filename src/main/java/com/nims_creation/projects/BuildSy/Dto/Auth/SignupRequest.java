package com.nims_creation.projects.BuildSy.Dto.Auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SignupRequest(
        @Email @NotNull String email,
        @Size(min = 2, max = 30) String name,
        @Size(min = 6,max = 20) String password
) {
}
