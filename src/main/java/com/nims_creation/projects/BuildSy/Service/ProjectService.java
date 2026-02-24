package com.nims_creation.projects.BuildSy.Service;

import com.nims_creation.projects.BuildSy.Dto.Project.ProjectRequest;
import com.nims_creation.projects.BuildSy.Dto.Project.ProjectResponse;
import com.nims_creation.projects.BuildSy.Dto.Project.ProjectSummaryResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getUserProjectById(Long id, Long userId);

    ProjectResponse createProject(ProjectRequest request, Long userId);

    ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);

    void softDelete(Long id, Long userId);

}
