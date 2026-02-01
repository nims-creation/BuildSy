package com.nims_creation.projects.BuildSy.Dto.Auth.Member;

import com.nims_creation.projects.BuildSy.Entity.Enum.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
