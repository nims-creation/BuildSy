package com.nims_creation.projects.BuildSy.Service;

import com.nims_creation.projects.BuildSy.Dto.Auth.Subscription.CheckoutRequest;
import com.nims_creation.projects.BuildSy.Dto.Auth.Subscription.CheckoutResponse;
import com.nims_creation.projects.BuildSy.Dto.Auth.Subscription.PortalResponse;
import com.nims_creation.projects.BuildSy.Dto.Auth.Subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);

}
