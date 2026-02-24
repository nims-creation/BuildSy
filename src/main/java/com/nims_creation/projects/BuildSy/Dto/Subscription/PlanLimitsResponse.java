package com.nims_creation.projects.BuildSy.Dto.Subscription;

public record PlanLimitsResponse(
        String planName,
        Integer maxTokensPerDay,
        Integer maxProjects,
        Boolean unlimitedAi

) {
}
