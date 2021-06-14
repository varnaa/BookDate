package com.varnaa.bookdate.config;

import com.varnaa.bookdate.model.Customer;
import com.varnaa.bookdate.model.HostedPage;
import com.varnaa.bookdate.serializer.CustomSerializer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateService {
    private final String RESOURCE_URL = "https://subscriptions.zoho.in/api/v1/";
    private final String HEADER_NAME_AUTHORIZATION = "Authorization";
    private final String HEADER_VALUE_AUTHORIZATION_VALUE = "Zoho-oauthtoken ";
    private final String HEADER_NAME_ORGANIZATION_ID = "X-com-zoho-subscriptions-organizationid";
    private final String HEADER_VALUE_ORGANIZATION_ID = "60009494013";
    private final String HEADER_NAME_CONTENT_TYPE = "Content-Type";
    private final String HEADER_VALUE_CONTENT_TYPE = "application/json;charset=utf-8";
    private final RestTemplate REST_TEMPLATE;
    private HttpHeaders httpHeaders;
    private HttpEntity httpEntity;

    @Autowired
    private CustomSerializer customSerializer;

    @Autowired
    private Logger logger;

    public RestTemplateService() {
        this.httpHeaders = new HttpHeaders();
        this.REST_TEMPLATE = new RestTemplate();
        httpHeaders.set(HEADER_NAME_AUTHORIZATION, HEADER_VALUE_AUTHORIZATION_VALUE);
        httpHeaders.set(HEADER_NAME_ORGANIZATION_ID, HEADER_VALUE_ORGANIZATION_ID);
        httpHeaders.set(HEADER_NAME_CONTENT_TYPE, HEADER_VALUE_CONTENT_TYPE);
    }

    public ResponseEntity<String> postCustomer(Customer customer, String URI) {
        logger.trace("customer api call made to zoho subscription.");
        httpEntity = new HttpEntity(customSerializer.getCustomerJSON(customer), httpHeaders);
        return REST_TEMPLATE.postForEntity(RESOURCE_URL + URI, httpEntity, String.class);
    }


    public ResponseEntity<String> hostedPageNewSubscription(HostedPage hostedPage) {
        logger.trace("create hosted page api call made to zoho subscription");
        httpEntity = new HttpEntity(customSerializer.getCreateHostedPageJSON(hostedPage), httpHeaders);
        return REST_TEMPLATE.postForEntity(RESOURCE_URL + "/hostedpages/newsubscription", httpEntity, String.class);
    }


    public ResponseEntity<String> hostedPageSubscription(HostedPage hostedPage) {
        logger.trace("create hosted page api call made to zoho subscription");
        httpEntity = new HttpEntity(customSerializer.getUpdateHostedPageJSON(hostedPage), httpHeaders);
        return REST_TEMPLATE.postForEntity(RESOURCE_URL + "/hostedpages/updatesubscription", httpEntity, String.class);
    }


    public ResponseEntity<String> cancelSubscription(String subscriptionId) {
        httpEntity = new HttpEntity(httpHeaders);
        logger.trace("cancel subscription call made to zoho subscription");
        return REST_TEMPLATE.postForEntity(RESOURCE_URL + "subscriptions/{subscriptionId}/cancel?cancel_at_end=true",
                httpEntity, String.class,
                subscriptionId);
    }

    public ResponseEntity<String> reactivateSubscription(String subscriptionId) {
        httpEntity = new HttpEntity(httpHeaders);
        logger.trace("reactivate subscription call made to zoho subscription");
        return REST_TEMPLATE.postForEntity(RESOURCE_URL + "subscriptions/{subscriptionId}/reactivate",
                httpEntity, String.class,
                subscriptionId);
    }
}
