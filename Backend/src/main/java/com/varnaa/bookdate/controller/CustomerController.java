package com.varnaa.bookdate.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.varnaa.bookdate.model.Customer;
import com.varnaa.bookdate.model.Subscription;
import com.varnaa.bookdate.service.CustomViewService;
import com.varnaa.bookdate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomViewService customViewService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String customerId) {
        Customer customer = customerService.findById(customerId);
        if (customer == null) {
            return new ResponseEntity("invalid id", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Customer> postCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) throws JsonProcessingException {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity("invalid request", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public HttpStatus putCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) throws JsonProcessingException {
        if (bindingResult.hasErrors()) {
            return HttpStatus.BAD_REQUEST;
        }
        customerService.update(customer);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{customerId")
    public HttpStatus deleteCustomer(@PathVariable String customerId) {
        boolean result = customerService.deleteById(customerId);
        if (result) {
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_FOUND;
    }

    @GetMapping("/{customerId}/filter")
    public List<Subscription> filterSubscription(@PathVariable("customerId") String customerId,
                                                 @RequestParam Map<String, String> queryParameters) {
        System.out.println(customerId);
        System.out.println(queryParameters);
        List<Subscription> result = new ArrayList<>();
        result.addAll(customViewService.filterSubscription(queryParameters));
        System.out.println("From controller-<" + result);
        return result;
    }

}

