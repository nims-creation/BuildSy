package com.nims_creation.projects.BuildSy.Service;

import com.nims_creation.projects.BuildSy.Dto.Project.FileContentResponse;
import com.nims_creation.projects.BuildSy.Dto.Project.FileNode;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);

}
