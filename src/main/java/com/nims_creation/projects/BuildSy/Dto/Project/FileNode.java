package com.nims_creation.projects.BuildSy.Dto.Project;

import java.time.Instant;

public record FileNode(
        String path,
        Instant modifiedAt,
        Long size,
        String type
) {
}

