package com.varnaa.bookdate.repository;

import com.varnaa.bookdate.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
