package com.thtek.irctcautobooker.entity;

import org.springframework.stereotype.Component;

public class NewPackRequest {

    public String userId;
    public String subscriptionPlan;
    public int validity;
    public long buytimestamp;
    public long expirytimestamp;

    public NewPackRequest() {
    }

    public NewPackRequest(String userId, String subscriptionPlan, int validity, long buytimestamp, long expirytimestamp) {
        this.userId = userId;
        this.subscriptionPlan = subscriptionPlan;
        this.validity = validity;
        this.buytimestamp = buytimestamp;
        this.expirytimestamp = expirytimestamp;
    }

    public String getUserId() {
        return userId;
    }

    public String getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public int getValidity() {
        return validity;
    }

    public long getBuytimestamp() {
        return buytimestamp;
    }

    public long getExpirytimestamp() {
        return expirytimestamp;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSubscriptionPlan(String subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public void setBuytimestamp(long buytimestamp) {
        this.buytimestamp = buytimestamp;
    }

    public void setExpirytimestamp(long expirytimestamp) {
        this.expirytimestamp = expirytimestamp;
    }
}
