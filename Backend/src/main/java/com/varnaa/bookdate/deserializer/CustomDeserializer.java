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


    /**
     * Extracts customer id from json response
     *
     * @param responseEntity from post  api call
     * @return customer id from the response body
     * @throws JsonProcessingException
     */
    public String getCustomerId(ResponseEntity<String> responseEntity) throws JsonProcessingException {
        JsonNode customerNode = objectMapper.readTree(responseEntity.getBody()).get("customer");
        Customer customer = objectMapper.convertValue(customerNode, Customer.class);
        logger.trace("Extracted customer node from json response");
        return customer.getCustomerId();
    }

    /**
     * Extracts newly generated hostedpage url from json response
     *
     * @param response from the post api call
     * @return hostedpage url
     * @throws JsonProcessingException
     */
    public String getHostedPageURL(ResponseEntity<String> response) throws JsonProcessingException {
        JsonNode hostedPageNode = objectMapper.readTree(response.getBody()).get("hostedpage");
        HostedPage hostedPage = objectMapper.convertValue(hostedPageNode, HostedPage.class);
        return hostedPage.getUrl();
    }

    /**
     * Converts subscription json response to POJO
     *
     * @param response from the cancel & reactivate subscription api call
     * @return Subscription POJO
     * @throws JsonProcessingException
     */
    public Subscription getSubscription(ResponseEntity<String> response) throws JsonProcessingException {
        JsonNode subscritpionNode = objectMapper.readTree(response.getBody()).get("subscription");
        logger.trace("Extracted subscription node from json response");
        return objectMapper.convertValue(subscritpionNode, Subscription.class);
    }

    /**
     * Converts subscription json response to POJO
     *
     * @param response from get hosted page api call
     * @return Subscription POJO
     * @throws JsonProcessingException
     */
    public Subscription getSubscriptionFromHostedpage(ResponseEntity<String> response) throws JsonProcessingException {
        JsonNode node = objectMapper.readTree(response.getBody()).get("data");
        JsonNode subscriptionNode = objectMapper.readTree(response.getBody()).get("data").get("subscription");
        Subscription subscription = objectMapper.convertValue(subscriptionNode, Subscription.class);
        logger.info("Extracted subscription node from json response");
        return subscription;
    }
}
