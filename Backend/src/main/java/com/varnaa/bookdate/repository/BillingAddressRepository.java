package com.varnaa.bookdate.repository;

import com.varnaa.bookdate.model.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface BillingAddressRepository extends JpaRepository<BillingAddress, Integer> {
}
