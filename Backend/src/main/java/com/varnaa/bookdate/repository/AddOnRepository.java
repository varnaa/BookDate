package com.varnaa.bookdate.repository;

import com.varnaa.bookdate.model.AddOn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface AddOnRepository extends JpaRepository<AddOn, String> {
}
