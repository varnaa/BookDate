package com.varnaa.bookdate.serializer;

import com.varnaa.bookdate.model.Customer;
import com.varnaa.bookdate.model.HostedPage;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomSerializer {

    @Autowired
    private Logger logger;

    public JSONObject getCustomerJSON(Customer customer) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("display_name", customer.getDisplayName());
        jsonObject.put("first_name", customer.getFirstName());
        jsonObject.put("last_name", customer.getLastName());
        jsonObject.put("email", customer.getEmail());
        jsonObject.put("mobile", customer.getMobile());
        jsonObject.put("shipping_address", customer.getShippingAddress());
        jsonObject.put("billing_address", customer.getBillingAddress());
        logger.trace("successfully converted customer POJO to json format");
        return jsonObject;
    }

    public JSONObject getCreateHostedPageJSON(HostedPage hostedPage) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("customer_id", hostedPage.getCustomerId());
        jsonObject.put("plan", hostedPage.getPlan());
        jsonObject.put("addons", hostedPage.getAddons());
        jsonObject.put("starts_at", hostedPage.getStartsAt());
        jsonObject.put("coupon_code", hostedPage.getCouponCode());
        logger.trace("successfully converted hosted page POJO to json format");
        return jsonObject;
    }

    public JSONObject getUpdateHostedPageJSON(HostedPage hostedPage) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("subscription_id", hostedPage.getSubscriptionsId());
        jsonObject.put("plan", hostedPage.getPlan());
        jsonObject.put("addons", hostedPage.getAddons());
        jsonObject.put("coupon_code", hostedPage.getCouponCode());
        logger.trace("successfully converted hosted page POJO to json format");
        return jsonObject;
    }
}
