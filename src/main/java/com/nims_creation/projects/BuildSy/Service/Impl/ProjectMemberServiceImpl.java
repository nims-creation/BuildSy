package com.nims_creation.projects.BuildSy.Service.Impl;

import com.nims_creation.projects.BuildSy.Dto.Project.ProjectRequest;
import com.nims_creation.projects.BuildSy.Dto.Project.ProjectResponse;
import com.nims_creation.projects.BuildSy.Dto.Project.ProjectSummaryResponse;
import com.nims_creation.projects.BuildSy.Service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMemberServiceImpl implements ProjectService {
    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        return List.of();
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        return null;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        return null;
    }

    @Override
    public void softDelete(Long id, Long userId) {

    }
}
