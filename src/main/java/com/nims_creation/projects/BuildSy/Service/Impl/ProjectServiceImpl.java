package com.nims_creation.projects.BuildSy.Service.Impl;

import com.nims_creation.projects.BuildSy.Dto.Project.ProjectRequest;
import com.nims_creation.projects.BuildSy.Dto.Project.ProjectResponse;
import com.nims_creation.projects.BuildSy.Dto.Project.ProjectSummaryResponse;
import com.nims_creation.projects.BuildSy.Entity.Enum.ProjectRole;
import com.nims_creation.projects.BuildSy.Entity.Project;
import com.nims_creation.projects.BuildSy.Entity.ProjectMember;
import com.nims_creation.projects.BuildSy.Entity.ProjectMemberId;
import com.nims_creation.projects.BuildSy.Entity.User;
import com.nims_creation.projects.BuildSy.Error.ResourceNotFoundException;
import com.nims_creation.projects.BuildSy.Mapper.ProjectMapper;
import com.nims_creation.projects.BuildSy.Repository.ProjectMemberRepository;
import com.nims_creation.projects.BuildSy.Repository.ProjectRepository;
import com.nims_creation.projects.BuildSy.Repository.UserRepository;
import com.nims_creation.projects.BuildSy.Security.AuthUtil;
import com.nims_creation.projects.BuildSy.Service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectMapper projectMapper;
    private final AuthUtil authUtil;



    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();

        User owner = userRepository.getReferenceById(userId);

        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();

        project = projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();

        projectMemberRepository.save(projectMember);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects() {
        Long userId = authUtil.getCurrentUserId();
        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }


    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")
    public ProjectResponse getUserProjectById(Long id) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(id, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(id, userId);
        project.setName(request.name());
        projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(id, userId);

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId, userId)
                .orElseThrow(()->new ResourceNotFoundException("Project", projectId.toString()));
    }
}
