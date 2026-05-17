package com.thtek.irctcautobooker.respository;

import com.thtek.irctcautobooker.model.SubscriptionPlansInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface SubscriptionPlansInfoRepository extends JpaRepository<SubscriptionPlansInfo, Integer> {

    @Query("SELECT s.id FROM SubscriptionPlansInfo s WHERE s.subscriptionPlan = :subscriptionPlan and s.validity = :validity and s.isActive = true ORDER BY s.id LIMIT 1")
    public Integer getSubscriptionPlanId(@Param("subscriptionPlan") String subscriptionPlan, @Param("validity") Integer validity);

}
