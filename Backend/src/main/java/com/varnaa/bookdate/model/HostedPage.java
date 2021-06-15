package com.varnaa.bookdate.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class HostedPage {
    @Column(name = "ID", nullable = false)
    @Id
    private String id;

    @JsonProperty(value = "customer_id")
    private String customerId;

    @JsonProperty(value = "plan")
    @OneToOne
    private Plan plan;

    @JsonProperty(value = "addons")
    @OneToMany
    private List<AddOn> addons;

    @JsonProperty(value = "coupon_code")
    private String couponCode;

    @JsonProperty(value = "starts_at")
    private String startsAt;

    @JsonProperty(value = "subscription_id")
    private String subscriptionsId;

    @JsonProperty
    private String url;

    public HostedPage() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public List<AddOn> getAddons() {
        return addons;
    }

    public void setAddons(List<AddOn> addons) {
        this.addons = addons;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(String startsAt) {
        this.startsAt = startsAt;
    }

    public String getSubscriptionsId() {
        return subscriptionsId;
    }

    public void setSubscriptionsId(String subscriptionsId) {
        this.subscriptionsId = subscriptionsId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}