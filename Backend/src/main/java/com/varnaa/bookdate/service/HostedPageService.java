package com.varnaa.bookdate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.varnaa.bookdate.config.RestTemplateService;
import com.varnaa.bookdate.deserializer.CustomDeserializer;
import com.varnaa.bookdate.model.HostedPage;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class HostedPageService {

    @Autowired
    private RestTemplateService restTemplateService;

    @Autowired
    private Logger logger;

    @Autowired
    private CustomDeserializer customDeserializer;

    public String getUrlForCreateSubscription(HostedPage hostedPage) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplateService.hostedPageNewSubscription(hostedPage);
        logger.trace("created hosted page for new subscription");
        return customDeserializer.getHostedPageURL(response);
    }

    public String getUrlForUpdateSubscription(HostedPage hostedPage) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplateService.hostedPageSubscription(hostedPage);
        logger.trace("created hosted page for update subscription");
        return customDeserializer.getHostedPageURL(response);
    }

}
