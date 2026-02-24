package com.nims_creation.projects.BuildSy.Service;

import com.nims_creation.projects.BuildSy.Dto.Subscription.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
