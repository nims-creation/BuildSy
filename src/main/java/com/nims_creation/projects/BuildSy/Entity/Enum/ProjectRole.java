package com.nims_creation.projects.BuildSy.Entity.Enum;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.nims_creation.projects.BuildSy.Entity.Enum.projectPermission.*;

@RequiredArgsConstructor
@Getter
public enum ProjectRole {
    EDITOR(Set.of(EDIT,DELETE,VIEW)),
    VIEWER(Set.of(VIEW)),
    OWNER(Set.of(EDIT,DELETE,VIEW,MANAGE_MEMBERS));

    private final Set<projectPermission> permissions;
}
