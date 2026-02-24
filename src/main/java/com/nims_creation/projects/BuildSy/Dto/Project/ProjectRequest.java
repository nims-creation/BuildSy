package com.nims_creation.projects.BuildSy.Dto.Project;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
        @NotBlank String name
) {
}
