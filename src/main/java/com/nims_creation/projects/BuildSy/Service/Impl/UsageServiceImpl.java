package com.nims_creation.projects.BuildSy.Service.Impl;

import com.nims_creation.projects.BuildSy.Dto.Subscription.PlanLimitsResponse;
import com.nims_creation.projects.BuildSy.Dto.Subscription.UsageTodayResponse;
import com.nims_creation.projects.BuildSy.Service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
