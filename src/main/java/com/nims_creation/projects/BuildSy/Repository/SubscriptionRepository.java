package com.nims_creation.projects.BuildSy.Repository;

import com.nims_creation.projects.BuildSy.Entity.Enum.SubscriptionStatus;
import com.nims_creation.projects.BuildSy.Entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Optional<Subscription> findByUserIdAndStatusIn(Long userId, Set<SubscriptionStatus> statusSet);

    boolean existsByStripeSubscriptionId(String subscriptionId);

    Optional<Subscription> findByStripeSubscriptionId(String gatewaySubscription);
}
