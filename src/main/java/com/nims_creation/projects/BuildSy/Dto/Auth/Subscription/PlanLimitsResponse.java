package com.nims_creation.projects.BuildSy.Dto.Auth.Subscription;

public record PlanLimitsResponse(
        String planName,
        int maxTokensPerDay,
        int maxProjects,
        boolean unlimitedAi

) {
}
