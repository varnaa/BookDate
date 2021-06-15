package com.varnaa.bookdate.repository;

import com.varnaa.bookdate.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface SubscriptionRepostory extends JpaRepository<Subscription, String> {
    Subscription findBySubscriptionId(String id);

    List<Subscription> findAllByCustomerId(String customerId);
}
