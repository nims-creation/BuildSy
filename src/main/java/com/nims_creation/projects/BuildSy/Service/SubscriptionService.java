package com.nims_creation.projects.BuildSy.Service;

import com.nims_creation.projects.BuildSy.Dto.Subscription.CheckoutRequest;
import com.nims_creation.projects.BuildSy.Dto.Subscription.CheckoutResponse;
import com.nims_creation.projects.BuildSy.Dto.Subscription.PortalResponse;
import com.nims_creation.projects.BuildSy.Dto.Subscription.SubscriptionResponse;
import com.nims_creation.projects.BuildSy.Entity.Enum.SubscriptionStatus;

import java.time.Instant;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId);

    void updateSubscription(String id, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId);

    void cancelSubscription(String id);
}
