package com.varnaa.bookdate.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.varnaa.bookdate.model.Customer;
import com.varnaa.bookdate.model.HostedPage;
import com.varnaa.bookdate.model.Subscription;
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

    public String getHostedPageURL(ResponseEntity<String> response) throws JsonProcessingException {
        JsonNode hostedPageNode = objectMapper.readTree(response.getBody()).get("hostedpage");
        HostedPage hostedPage = objectMapper.convertValue(hostedPageNode, HostedPage.class);
        return hostedPage.getUrl();
    }

    public Subscription getSubscription(ResponseEntity<String> response) throws JsonProcessingException {
        JsonNode subscritpionNode = objectMapper.readTree(response.getBody()).get("subscription");
        logger.trace("Extracted subscription node from json response");
        return objectMapper.convertValue(subscritpionNode, Subscription.class);
    }

    public Subscription getSubscriptionFromHostedpage(ResponseEntity<String> response) throws JsonProcessingException {
        JsonNode node = objectMapper.readTree(response.getBody()).get("data");
        System.out.println(node.toPrettyString());
        JsonNode subscriptionNode = objectMapper.readTree(response.getBody()).get("data").get("subscription");
        Subscription subscription = objectMapper.convertValue(subscriptionNode, Subscription.class);
        System.out.println(subscription.getCustomerId());
        logger.info("Extracted subscription node from json response");
        return subscription;
    }
}
