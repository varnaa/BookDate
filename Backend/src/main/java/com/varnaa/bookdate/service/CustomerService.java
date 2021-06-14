package com.varnaa.bookdate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.varnaa.bookdate.config.RestTemplateService;
import com.varnaa.bookdate.deserializer.CustomDeserializer;
import com.varnaa.bookdate.model.Customer;
import com.varnaa.bookdate.model.Subscription;
import com.varnaa.bookdate.repository.CustomerRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RestTemplateService restTemplateService;

    @Autowired
    private CustomDeserializer customDeserializer;

    @Autowired
    private Logger logger;

    public Customer findById(String customerId) {
        return customerRepository.getOne(customerId);
    }

    public Customer save(Customer customer, String URI) throws JsonProcessingException {
        try {
            ResponseEntity<String> responseEntity = restTemplateService.postCustomer(customer, URI);
            logger.trace("posted new customer to Zoho Subscription");
            customer.setCustomerId(customDeserializer.getCustomerId(responseEntity));
            customerRepository.save(customer);
            logger.trace("customer successfully saved to local db");
            return customer;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public boolean deleteById(String customerId) {
        try {
            customerRepository.deleteById(customerId);
            logger.trace("deleted customer -> " + customerId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Subscription> getAllSubscriptionsById(String customerId) {
        logger.trace("retrieved subscriptions for customer ->" + customerId);
        return customerRepository.findAllSubscriptionsByCustomerId(customerId);
    }


}
