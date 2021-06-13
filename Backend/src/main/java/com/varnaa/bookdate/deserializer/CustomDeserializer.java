package com.varnaa.bookdate.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.varnaa.bookdate.model.Customer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomDeserializer {
    @Autowired
    private final ObjectMapper objectMapper;

    @Autowired
    private Logger logger;

    public CustomDeserializer() {
        this.objectMapper = new ObjectMapper();
    }

    public String getCustomerId(ResponseEntity<String> responseEntity) throws JsonProcessingException {
        JsonNode customerNode = objectMapper.readTree(responseEntity.getBody()).get("customer");
        Customer customer = objectMapper.convertValue(customerNode, Customer.class);
        logger.trace("Extracted customer node from json response");
        return customer.getCustomerId();
    }

    public Customer getCustomer(ResponseEntity<String> responseEntity) throws JsonProcessingException {
        JsonNode customerNode = objectMapper.readTree(responseEntity.getBody()).get("customer");
        logger.trace("Extracted customer node from json response");
        return objectMapper.convertValue(customerNode, Customer.class);
    }

}
