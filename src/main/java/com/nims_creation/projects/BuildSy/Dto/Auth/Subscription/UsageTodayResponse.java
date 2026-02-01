package com.nims_creation.projects.BuildSy.Dto.Auth.Subscription;

public record UsageTodayResponse(
        int tokensUsed,
        int tokensLimit,
        int previewsRunning,
        int previewsLimit
) {
}
