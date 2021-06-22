package com.varnaa.bookdate.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.varnaa.bookdate.model.HostedPage;
import com.varnaa.bookdate.model.Subscription;
import com.varnaa.bookdate.service.HostedPageService;
import com.varnaa.bookdate.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers/{customerId}/subscriptions")
@CrossOrigin("*")
public class SubscriptionController {

    @Autowired
    private HostedPageService hostedPageService;

    @Autowired
    private SubscriptionService subscriptionService;


    @PostMapping("/")
    public ResponseEntity<String> postNewSubscription(@RequestBody HostedPage hostedPage) throws JsonProcessingException {
        String hostedPageLink = hostedPageService.getUrlForCreateSubscription(hostedPage);
        return new ResponseEntity<>(hostedPageLink, HttpStatus.OK);
    }

    @PostMapping("/{subscriptionId}")
    public ResponseEntity<String> postUpdateSubscription(@RequestBody HostedPage hostedPage) throws JsonProcessingException {
        String hostedPageLink = hostedPageService.getUrlForUpdateSubscription(hostedPage);
        return new ResponseEntity<>(hostedPageLink, HttpStatus.OK);
    }

    @GetMapping("/")
    public @ResponseBody
    List<Subscription> getAllSubscriptions(@PathVariable String customerId) {
        List<Subscription> list = new ArrayList<>();
        list.addAll(subscriptionService.getAll(customerId));
        return list;
    }

    @PostMapping("/{subscriptionId}/cancel")
    public HttpStatus cancel(@PathVariable String subscriptionId) throws JsonProcessingException {
        try {
            subscriptionService.cancel(subscriptionId);
            return HttpStatus.OK;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return HttpStatus.BAD_REQUEST;
        }
    }

    @PostMapping("/{subscriptionId}/reactivate")
    public HttpStatus reactivate(@PathVariable String subscriptionId) throws JsonProcessingException {
        try {
            subscriptionService.reactivate(subscriptionId);
            return HttpStatus.OK;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return HttpStatus.BAD_REQUEST;
        }
    }
}
