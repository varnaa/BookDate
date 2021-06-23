package com.varnaa.bookdate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.varnaa.bookdate.config.RestTemplateService;
import com.varnaa.bookdate.deserializer.CustomDeserializer;
import com.varnaa.bookdate.model.Subscription;
import com.varnaa.bookdate.repository.SubscriptionRepostory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SubscriptionService {

    @Autowired
    private RestTemplateService restTemplateService;

    @Autowired
    private SubscriptionRepostory subscriptionRepostory;

    @Autowired
    private Logger logger;

    @Autowired
    private CustomDeserializer deserializer;

    public void save(String hostedpageId) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplateService.getHostedPageDetails(hostedpageId);
        Subscription subscription = deserializer.getSubscriptionFromHostedpage(response);
        subscriptionRepostory.save(subscription);
    }

    public void cancel(String subscriptionId) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplateService.cancelSubscription(subscriptionId);
        Subscription subscription = deserializer.getSubscription(response);
        subscriptionRepostory.save(subscription);
        logger.info("updated subscription ->" + subscriptionId + " in local db");
    }

    public void reactivate(String subscriptionId) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplateService.reactivateSubscription(subscriptionId);
        Subscription subscription = deserializer.getSubscription(response);
        subscriptionRepostory.save(subscription);
        logger.info("updated subscription ->" + subscriptionId + " in local db");
    }

    public List<Subscription> getAll(String customerId) {
        return subscriptionRepostory.findAllByCustomerId(customerId);
    }

}
