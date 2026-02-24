package com.nims_creation.projects.BuildSy.Dto.Member;

import com.nims_creation.projects.BuildSy.Entity.Enum.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest (
        @NotNull ProjectRole role
){
}
