package com.nims_creation.projects.BuildSy.Mapper;

import com.nims_creation.projects.BuildSy.Dto.Project.ProjectResponse;
import com.nims_creation.projects.BuildSy.Dto.Project.ProjectSummaryResponse;
import com.nims_creation.projects.BuildSy.Entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);
    ProjectSummaryResponse toProjectSummaryResponse(Project project);
    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);
}
