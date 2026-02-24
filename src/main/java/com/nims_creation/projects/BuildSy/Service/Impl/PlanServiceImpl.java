package com.nims_creation.projects.BuildSy.Service.Impl;

import com.nims_creation.projects.BuildSy.Dto.Subscription.PlanResponse;
import com.nims_creation.projects.BuildSy.Service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
