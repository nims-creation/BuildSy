package com.nims_creation.projects.BuildSy.Service;

import com.nims_creation.projects.BuildSy.Dto.Subscription.CheckoutRequest;
import com.nims_creation.projects.BuildSy.Dto.Subscription.CheckoutResponse;
import com.nims_creation.projects.BuildSy.Dto.Subscription.PortalResponse;


public interface PaymentProcessor {

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);

    PortalResponse openCustomerPortal(Long userId);
}
