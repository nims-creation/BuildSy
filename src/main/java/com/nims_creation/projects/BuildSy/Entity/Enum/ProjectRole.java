package com.nims_creation.projects.BuildSy.Entity.Enum;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.nims_creation.projects.BuildSy.Entity.Enum.ProjectPermission.*;

@RequiredArgsConstructor
@Getter
public enum ProjectRole {
    EDITOR(Set.of(EDIT,DELETE,VIEW,VIEW_MEMBERS)),
    VIEWER(Set.of(VIEW,VIEW_MEMBERS)),
    OWNER(Set.of(EDIT,DELETE,VIEW,MANAGE_MEMBERS,VIEW_MEMBERS));

    private final Set<ProjectPermission> permissions;
}
