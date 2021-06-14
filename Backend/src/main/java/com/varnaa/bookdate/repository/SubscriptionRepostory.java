package com.varnaa.bookdate.repository;

import com.varnaa.bookdate.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface SubscriptionRepostory extends JpaRepository<Subscription,String> {
    Subscription findBySubscriptionId(String id);
}
