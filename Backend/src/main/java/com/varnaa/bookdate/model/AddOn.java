package com.varnaa.bookdate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ADD_ON")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddOn {

    @Id
    @JsonProperty(value = "addon_code")
    private String addon_code;

    @JsonProperty
    private String quantity;

    @JsonProperty
    private String type;

    @JsonProperty
    private int price;

    public AddOn() {
    }

    public AddOn(String addon_code, String quantity, String type, int price) {
        this.addon_code = addon_code;
        this.quantity = quantity;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}