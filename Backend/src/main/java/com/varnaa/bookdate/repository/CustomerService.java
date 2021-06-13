package com.varnaa.bookdate.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.varnaa.bookdate.config.RestTemplateService;
import com.varnaa.bookdate.deserializer.CustomDeserializer;
import com.varnaa.bookdate.model.Customer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

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

    public boolean save(Customer customer) throws JsonProcessingException {
        try {
            ResponseEntity<String> responseEntity = restTemplateService.postCustomer(customer);
            logger.trace("posted new customer to Zoho Subscription");
            customer.setCustomerId(customDeserializer.getCustomerId(responseEntity));
            customerRepository.save(customer);
            logger.trace("customer successfully saved to local db");
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }
}
