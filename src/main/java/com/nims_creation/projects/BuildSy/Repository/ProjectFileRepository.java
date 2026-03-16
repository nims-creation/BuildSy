package com.nims_creation.projects.BuildSy.Repository;

import com.nims_creation.projects.BuildSy.Entity.ProjectFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectFileRepository extends JpaRepository<ProjectFile, Long> {
}
