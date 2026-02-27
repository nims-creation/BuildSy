package com.nims_creation.projects.BuildSy.Dto.Member;

import com.nims_creation.projects.BuildSy.Entity.Enum.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long userId,
        String username,
        String name,
        ProjectRole projectRole,
        Instant invitedAt
) {
}

