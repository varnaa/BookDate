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
    private int billing_cycles;

    @JsonProperty
    private int price;

    public Plan() {
    }

    public Plan(String plan_code, String plan_description, int quantity, int billing_cycles, int price) {
        this.plan_code = plan_code;
        this.plan_description = plan_description;
        this.quantity = quantity;
        this.billing_cycles = billing_cycles;
        this.price = price;
    }

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

    public int getBilling_cycles() {
        return billing_cycles;
    }

    public void setBilling_cycles(int billing_cycles) {
        this.billing_cycles = billing_cycles;
    }
}