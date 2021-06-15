package com.varnaa.bookdate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "PLAN")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Plan {
    @Id
    @JsonProperty(value = "plan_code")
    private String plan_code;

    @JsonProperty(value = "plan_description")
    private String plan_description;

    @JsonProperty
    private int quantity;

    @JsonProperty
    private int price;

    @JsonProperty(value = "billing_cycles")
    private int billingCycles;


    public String getPlan_code() {
        return plan_code;
    }

    public void setPlan_code(String plan_code) {
        this.plan_code = plan_code;
    }

    public String getPlan_description() {
        return plan_description;
    }

    public void setPlan_description(String plan_description) {
        this.plan_description = plan_description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBillingCycles() {
        return billingCycles;
    }

    public void setBillingCycles(int billingCycles) {
        this.billingCycles = billingCycles;
    }
}