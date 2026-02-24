package com.nims_creation.projects.BuildSy.Service;

import com.nims_creation.projects.BuildSy.Dto.Subscription.PlanLimitsResponse;
import com.nims_creation.projects.BuildSy.Dto.Subscription.UsageTodayResponse;

public interface UsageService {

    UsageTodayResponse getTodayUsageOfUser(Long userId);
    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);

}
