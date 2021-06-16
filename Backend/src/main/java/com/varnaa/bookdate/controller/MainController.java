package com.varnaa.bookdate.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.varnaa.bookdate.model.AddOn;
import com.varnaa.bookdate.model.Plan;
import com.varnaa.bookdate.model.User;
import com.varnaa.bookdate.repository.AddOnRepository;
import com.varnaa.bookdate.repository.PlanRepository;
import com.varnaa.bookdate.repository.UserRepository;
import com.varnaa.bookdate.service.CustomerService;
import com.varnaa.bookdate.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class MainController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private AddOnRepository addOnRepository;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User loginDetails) {
        Map<String, String> response = new HashMap<>();
        User user = userRepository.findByEmail(loginDetails.getEmail());
        if (user == null || !user.getPassword().equals(loginDetails.getPassword())) {
            response.put("response", "invalid user");
            return response;
        } else {
            String customerId = customerService.getCustomerId(user.getId());
            response.put("response", customerId);
            return response;
        }
    }

    @RequestMapping("/confirmsubscription")
    public String getHostedPage(@RequestParam("hostedpage_id") String hostedpageId) throws JsonProcessingException {
        subscriptionService.save(hostedpageId);
        return "Thanks for subscribing with us.!";
    }

    @GetMapping("/plans")
    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }


    @GetMapping("/addons")
    public List<AddOn> getAllAddons() {
        return addOnRepository.findAll();
    }
}
