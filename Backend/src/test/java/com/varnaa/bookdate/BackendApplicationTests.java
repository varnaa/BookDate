package com.varnaa.bookdate;

import com.varnaa.bookdate.deserializer.CustomDeserializer;
import com.varnaa.bookdate.model.Customer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    private CustomDeserializer deserializer;
    private RestTemplate restTemplate;
    private final String url = "http://localhost:8080/customers/";

    @Test
    void GETCustomerTest() {
        String customerId = "575791000000019188";
        ResponseEntity<Customer> response = restTemplate.getForEntity(url + customerId, Customer.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void POSTCustomerTest() {
        Customer customer = new Customer("", "Test", "test", "value", "test@gmail.com", 123456789, null, null, null);
        HttpEntity entity = new HttpEntity(customer);
        ResponseEntity<Customer> response = restTemplate.postForEntity(url, entity, Customer.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void cancelSubscriptionTest() {
        String customerId = "575791000000019188";
        String subscriptionId = "575791000000019230";
        ResponseEntity response = restTemplate.postForEntity(url + customerId + "/subscription/" + subscriptionId + "/cancel;", HttpMethod.POST, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void reactivateSubscriptionTest() {
        String customerId = "575791000000019188";
        String subscriptionId = "575791000000019230";
        ResponseEntity response = restTemplate.postForEntity(url + customerId + "/subscription/" + subscriptionId + "/reactivate", HttpMethod.POST, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

}
