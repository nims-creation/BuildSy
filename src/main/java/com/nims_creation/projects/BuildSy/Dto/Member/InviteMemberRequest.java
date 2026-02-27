package com.nims_creation.projects.BuildSy.Dto.Member;

import com.nims_creation.projects.BuildSy.Entity.Enum.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(
        @Email @NotBlank String username,
        @NotNull ProjectRole role
) {
}
