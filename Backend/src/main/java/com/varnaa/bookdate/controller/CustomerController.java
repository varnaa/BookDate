package com.varnaa.bookdate.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.varnaa.bookdate.model.Customer;
import com.varnaa.bookdate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // CRUD for customer

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String customerId) {
        Customer customer = customerService.findById(customerId);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Customer> postCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) throws JsonProcessingException {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity("invalid request", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerService.save(customer, "/customer"), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Customer> putCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) throws JsonProcessingException {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity("invalid request", HttpStatus.BAD_REQUEST);
        }
        String URI = "/customer/" + customer.getCustomerId();
        return new ResponseEntity<>(customerService.save(customer, URI), HttpStatus.OK);
    }

    @DeleteMapping("/{customerId")
    public HttpStatus deleteCustomer(@PathVariable String customerId) {
        boolean result = customerService.deleteById(customerId);
        if (result) {
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_FOUND;
    }


}
