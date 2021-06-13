package com.varnaa.bookdate.serializer;

import com.varnaa.bookdate.model.Customer;
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
        logger.trace("successfully converted customer POJO to json");
        return jsonObject;
    }
}
