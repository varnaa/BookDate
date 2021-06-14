package com.varnaa.bookdate.config;

import com.varnaa.bookdate.model.Customer;
import com.varnaa.bookdate.serializer.CustomSerializer;
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
    private final String HEADER_VALUE_AUTHORIZATION_VALUE="Zoho-oauthtoken ";
    private final String HEADER_NAME_ORGGANIZATION_ID="X-com-zoho-subscriptions-organizationid";
    private final String HEADER_VALUE_ORGANIZATION_ID = "60009494013";
    private final String HEADER_NAME_CONTENT_TYPE="Content-Type";
    private final String HEADER_VALUE_CONTENT_TYPE="application/json;charset=utf-8";
    private HttpHeaders httpHeaders;
    private HttpEntity httpEntity;
    private RestTemplate restTemplate;

    @Autowired
    private CustomSerializer customSerializer;

    public RestTemplateService(){
        this.httpHeaders = new HttpHeaders();
        this.restTemplate = new RestTemplate();
        httpHeaders.set(HEADER_NAME_AUTHORIZATION,HEADER_VALUE_AUTHORIZATION_VALUE);
        httpHeaders.set(HEADER_NAME_ORGGANIZATION_ID,HEADER_VALUE_ORGANIZATION_ID);
        httpHeaders.set(HEADER_NAME_CONTENT_TYPE,HEADER_VALUE_CONTENT_TYPE);
    }

    public ResponseEntity<String> postCustomer(Customer customer){
        httpEntity = new HttpEntity(customSerializer.getCustomerJSON(customer), httpHeaders);
        return restTemplate.postForEntity(RESOURCE_URL+"/customers", httpEntity, String.class);
    }


}
