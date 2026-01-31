package com.nims_creation.projects.BuildSy.Entity;

import com.nims_creation.projects.BuildSy.Entity.Enum.ProjectRole;

import java.time.Instant;

public class ProjectMember {

    ProjectMemberId id;
    Project project;

    User user;
    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;
}

