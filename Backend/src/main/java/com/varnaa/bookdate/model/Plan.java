package com.varnaa.bookdate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "PLAN")
@Entity
public class Plan {
    @Id
    @JsonProperty(value = "plan_code")
    private String planCode;

    @JsonProperty(value = "plan_description")
    private String planDescription;

    @JsonProperty
    private int quantity;

    @JsonProperty
    private int price;

    @JsonProperty(value = "billing_cycles")
    private int billingCycles;


    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
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