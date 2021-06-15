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

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
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
    public String login(@Valid @RequestBody User loginDetails) {
        Optional<User> user = userRepository.findById(loginDetails.getEmail());
        if (user.isEmpty() || !user.get().getPassword().equals(loginDetails.getPassword())) {
            return "Invalid user";
        } else {
            return customerService.getCustomerId(user.get().getId());
        }
    }

    @RequestMapping("/confirmsubscription")
    public void getHostedPage(@RequestParam("hostedpage_id") String hostedpageId) throws JsonProcessingException {
        subscriptionService.save(hostedpageId);
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
