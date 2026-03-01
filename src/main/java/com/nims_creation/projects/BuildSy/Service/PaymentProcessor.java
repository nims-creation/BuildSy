package com.nims_creation.projects.BuildSy.Service;

import com.nims_creation.projects.BuildSy.Dto.Subscription.CheckoutRequest;
import com.nims_creation.projects.BuildSy.Dto.Subscription.CheckoutResponse;
import com.nims_creation.projects.BuildSy.Dto.Subscription.PortalResponse;
import com.stripe.model.StripeObject;

import java.util.Map;


public interface PaymentProcessor {

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);

    PortalResponse openCustomerPortal(Long userId);

    void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metadata);

}
