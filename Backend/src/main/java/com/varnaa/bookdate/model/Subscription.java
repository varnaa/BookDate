package com.varnaa.bookdate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Table(name = "SUBSCRIPTION")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription {
    @Id
    @JsonProperty(value = "subscription_id")
    private String subscriptionId;

    @JsonProperty(value = "activated_at")
    private String activatedAt;

    @JsonProperty(value = "expires_at")
    private String expiresAt;

    @JsonProperty(value = "last_billing_at")
    private String lastBillingAt;

    @JsonProperty(value = "next_billing_at")
    private String nextBillingAt;

    @JsonProperty(value = "end_of_term")
    private boolean endOfTerm;

    @JoinColumn
    @ManyToOne
    @JsonProperty(value = "plan")
    private Plan plan;

    @JoinColumn
    @ManyToMany
    @JsonProperty(value = "add_ons")
    private List<AddOn> addOns;

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getActivatedAt() {
        return activatedAt;
    }

    public void setActivatedAt(String activatedAt) {
        this.activatedAt = activatedAt;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getLastBillingAt() {
        return lastBillingAt;
    }

    public void setLastBillingAt(String lastBillingAt) {
        this.lastBillingAt = lastBillingAt;
    }

    public String getNextBillingAt() {
        return nextBillingAt;
    }

    public void setNextBillingAt(String nextBillingAt) {
        this.nextBillingAt = nextBillingAt;
    }

    public boolean isEndOfTerm() {
        return endOfTerm;
    }

    public void setEndOfTerm(boolean endOfTerm) {
        this.endOfTerm = endOfTerm;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public List<AddOn> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<AddOn> addOns) {
        this.addOns = addOns;
    }
}