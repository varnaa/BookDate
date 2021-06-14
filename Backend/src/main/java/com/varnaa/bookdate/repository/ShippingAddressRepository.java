package com.varnaa.bookdate.repository;

import com.varnaa.bookdate.model.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress,Integer> {
}
