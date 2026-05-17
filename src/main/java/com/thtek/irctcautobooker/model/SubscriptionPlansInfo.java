package com.thtek.irctcautobooker.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table
public class SubscriptionPlansInfo {

    @Id
    int id;
    String subscriptionPlan;
    String name;
    int price;
    int validity;
    boolean isActive;

    public SubscriptionPlansInfo() {
    }

    public SubscriptionPlansInfo(int id,String subscriptionPlan, String name, int price, int validity, boolean isActive) {
        this.id = id;
        this.subscriptionPlan = subscriptionPlan;
        this.name = name;
        this.price = price;
        this.validity = validity;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(String subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }
}
