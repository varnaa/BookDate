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
    private String addOnCode;
    private String unit;
    private String type;
    private int price;

    public AddOn() {
    }

    public AddOn(String addOnCode, String unit, String type, int price) {
        this.addOnCode = addOnCode;
        this.unit = unit;
        this.type = type;
        this.price = price;
    }

    public String getAddOnCode() {
        return addOnCode;
    }

    public void setAddOnCode(String addOnCode) {
        this.addOnCode = addOnCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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