package com.varnaa.bookdate.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HostedPage {

    @JsonProperty(value = "customer_id")
    private String customerId;

    @JsonProperty
    private Plan plan;

    @JsonProperty
    private List<AddOn> addons;

    @JsonProperty(value = "coupon_code")
    private String couponCode;

    @JsonProperty(value = "starts_at")
    private String startsAt;

    @JsonProperty(value = "subscription_id")
    private String subscriptionsId;

}