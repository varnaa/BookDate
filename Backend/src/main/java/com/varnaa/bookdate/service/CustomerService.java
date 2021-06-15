package com.varnaa.bookdate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.varnaa.bookdate.config.RestTemplateService;
import com.varnaa.bookdate.deserializer.CustomDeserializer;
import com.varnaa.bookdate.model.Customer;
import com.varnaa.bookdate.repository.CustomerRepository;
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
        return customerRepository.findByCustomerId(customerId);
    }

    public Customer save(Customer customer) throws JsonProcessingException {
        try {
            ResponseEntity<String> responseEntity = restTemplateService.postCustomer(customer);
            logger.info("posted new customer to Zoho Subscription");
            customer.setCustomerId(customDeserializer.getCustomerId(responseEntity));
            customerRepository.save(customer);
            logger.info("customer successfully saved to local db");
            return customer;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public Customer update(Customer customer) throws JsonProcessingException {
        restTemplateService.updateCustomer(customer);
        customerRepository.save(customer);
        logger.info("customer successfully updated");
        return customer;
    }

    public boolean deleteById(String customerId) {
        try {
            customerRepository.deleteById(customerId);
            logger.info("deleted customer -> " + customerId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getCustomerId(int userid) {
        Customer customer = customerRepository.findByUser_IdIs(userid);
        return customer.getCustomerId();
    }

}
