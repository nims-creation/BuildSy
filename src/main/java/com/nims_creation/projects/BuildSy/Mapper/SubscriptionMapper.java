package com.nims_creation.projects.BuildSy.Mapper;

import com.nims_creation.projects.BuildSy.Dto.Subscription.PlanResponse;
import com.nims_creation.projects.BuildSy.Dto.Subscription.SubscriptionResponse;
import com.nims_creation.projects.BuildSy.Entity.Plan;
import com.nims_creation.projects.BuildSy.Entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanResponse toPlanResponse(Plan plan);
}
