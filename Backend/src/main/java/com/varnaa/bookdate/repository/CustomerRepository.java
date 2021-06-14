package com.varnaa.bookdate.repository;

import com.varnaa.bookdate.model.Customer;
import com.varnaa.bookdate.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Subscription> findAllSubscriptionsByCustomerId(String customerId);
}
