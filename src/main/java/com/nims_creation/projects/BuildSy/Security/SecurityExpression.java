package com.nims_creation.projects.BuildSy.Security;

import com.nims_creation.projects.BuildSy.Entity.Enum.ProjectRole;
import com.nims_creation.projects.BuildSy.Repository.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("security")
@RequiredArgsConstructor
public class SecurityExpression {

    private final ProjectMemberRepository projectMemberRepository;
    private final AuthUtil authUtil;


    public boolean canViewProject(Long projectId){
        Long userId = authUtil.getCurrentUserId();

        return projectMemberRepository.findRoleByProjectIdAndUserId(projectId, userId)
                .map(role-> role.equals(ProjectRole.OWNER) || role.equals(ProjectRole.EDITOR) || role.equals(ProjectRole.VIEWER))
                .orElse(false);
    }


    public boolean canEditProject(Long projectId){
        Long userId = authUtil.getCurrentUserId();

        return projectMemberRepository.findRoleByProjectIdAndUserId(projectId, userId)
                .map(role-> role.equals(ProjectRole.OWNER) || role.equals(ProjectRole.EDITOR))
                .orElse(false);
    }
}
