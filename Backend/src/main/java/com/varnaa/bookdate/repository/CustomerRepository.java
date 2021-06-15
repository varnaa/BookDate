package com.varnaa.bookdate.repository;

import com.varnaa.bookdate.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByCustomerId(String customerId);

    Customer findByUser_IdIs(int userId);
}
