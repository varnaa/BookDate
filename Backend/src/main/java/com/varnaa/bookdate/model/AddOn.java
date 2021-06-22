package com.varnaa.bookdate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Table(name = "ADD_ON")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Inheritance(strategy = InheritanceType.JOINED)
public class AddOn {

    @Id
    @JsonProperty(value = "addon_code")
    private String addon_code;

    @JsonProperty(value = "quantity")
    private String quantity;

    @JsonProperty(value = "price")
    private int price;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    public Subscription getSubscription() { return subscription; }

    public AddOn() {
    }

    public AddOn(String addon_code, String quantity, String type, int price) {
        this.addon_code = addon_code;
        this.quantity = quantity;
        this.price = price;
    }

    public String getAddon_code() {
        return addon_code;
    }

    public void setAddon_code(String addon_code) {
        this.addon_code = addon_code;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}