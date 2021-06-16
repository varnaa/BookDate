package com.varnaa.bookdate.config;

import com.varnaa.bookdate.model.Customer;
import com.varnaa.bookdate.model.HostedPage;
import com.varnaa.bookdate.serializer.CustomSerializer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateService {
    private final String RESOURCE_URL = "https://subscriptions.zoho.in/api/v1/";
    private final String HEADER_NAME_AUTHORIZATION = "Authorization";
    private final String HEADER_VALUE_AUTHORIZATION_VALUE = "Zoho-oauthtoken";
    private final String HEADER_NAME_ORGANIZATION_ID = "X-com-zoho-subscriptions-organizationid";
    private final String HEADER_VALUE_ORGANIZATION_ID = "60009577496";
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

    /**
     * Makes POST call to zoho subscriptions for creating new customer after
     * serializing customer object into a json body.
     *
     * @param customer object
     * @return response from the request
     */
    public ResponseEntity<String> postCustomer(Customer customer) {
        httpEntity = new HttpEntity(customSerializer.getCustomerJSON(customer), httpHeaders);
        logger.info("POST customer call made to zoho subscription");
        return REST_TEMPLATE.postForEntity(RESOURCE_URL + "/customers", httpEntity, String.class);
    }

    /**
     * Makes POST call to Zoho subscriptions for updating existing
     * user details after serializing customer object into a json body
     *
     * @param customer object
     */
    public void updateCustomer(Customer customer) {
        httpEntity = new HttpEntity(customSerializer.getCustomerJSON(customer), httpHeaders);
        String url = RESOURCE_URL + "customers/" + customer.getCustomerId();
        logger.info("POST customer call made to zoho subscription");
        REST_TEMPLATE.put(url, httpEntity, String.class);
    }


    /**
     * Makes POST call to Zoho subscriptions for generating hosted page link to
     * creating new subscription after serializing hostedpage object into json body.
     *
     * @param hostedPage
     * @return response from the request
     */
    public ResponseEntity<String> hostedPageNewSubscription(HostedPage hostedPage) {
        httpEntity = new HttpEntity(customSerializer.getCreateHostedPageJSON(hostedPage), httpHeaders);
        logger.info("create hosted page for new subscription call made to zoho subscription");
        return REST_TEMPLATE.postForEntity(RESOURCE_URL + "hostedpages/newsubscription", httpEntity, String.class);
    }


    /**
     * Makes POST call to Zoho subscriptions for generating hosted page link for
     * updating existing subscription after serializing hostedpage object into json body.
     *
     * @param hostedPage
     * @return response from the request
     */
    public ResponseEntity<String> hostedPageUpdateSubscription(HostedPage hostedPage) {
        httpEntity = new HttpEntity(customSerializer.getUpdateHostedPageJSON(hostedPage), httpHeaders);
        logger.info("create hosted page for update subscription call made to zoho subscription");
        return REST_TEMPLATE.postForEntity(RESOURCE_URL + "hostedpages/updatesubscription", httpEntity, String.class);
    }


    /**
     * Makes POST call to Zoho subscriptions to cancel existing subscription
     *
     * @param subscriptionId to be cancelled
     * @return response from the request
     */
    public ResponseEntity<String> cancelSubscription(String subscriptionId) {
        httpEntity = new HttpEntity(httpHeaders);
        String url = RESOURCE_URL + "subscriptions/" + subscriptionId + "/cancel?cancel_at_end=true";
        logger.info("cancel subscription call made to zoho subscription");
        return REST_TEMPLATE.postForEntity(url,
                                           httpEntity, String.class);
    }

    /**
     * Makes POST call to Zoho subscriptions to reactivate a subscription
     *
     * @param subscriptionId to be cancelled
     * @return response from the request
     */
    public ResponseEntity<String> reactivateSubscription(String subscriptionId) {
        httpEntity = new HttpEntity(httpHeaders);
        String url = RESOURCE_URL + "/subscriptions/" + subscriptionId + "/reactivate";
        logger.info("reactivate subscription call made to zoho subscription");
        return REST_TEMPLATE.postForEntity(url,
                                           httpEntity, String.class,
                                           subscriptionId);
    }

    /**
     * Makes GET call to Zoho subscriptions to retrieve the details of hosted page link
     *
     * @param hostedpageId
     * @return response from the request
     */
    public ResponseEntity<String> getHostedPageDetails(String hostedpageId) {
        httpEntity = new HttpEntity(httpHeaders);
        String url = RESOURCE_URL + "/hostedpages/" + hostedpageId;
        logger.info("get hostedpage call made to zoho subscription");
        return REST_TEMPLATE.exchange(url, HttpMethod.GET, httpEntity, String.class);
    }
}
