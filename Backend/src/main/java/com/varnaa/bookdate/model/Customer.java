package com.varnaa.bookdate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Table(name = "CUSTOMER")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    @Id
    @JsonProperty(value = "customer_id")
    private String customerId;

    @JsonProperty(value = "display_name")
    private String displayName;

    @JsonProperty(value = "first_name")
    private String firstName;

    @JsonProperty(value = "last_name")
    private String lastName;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "mobile")
    private long mobile;

    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty(value = "shipping_address")
    private ShippingAddress shippingAddress;

    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty(value = "billing_address")
    private BillingAddress billingAddress;

    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;


    public Customer() {
    }

    public Customer(String customerId, String displayName, String firstName, String lastName, String email, int mobile, ShippingAddress shippingAddress, BillingAddress billingAddress, User user) {
        this.customerId = customerId;
        this.displayName = displayName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

}