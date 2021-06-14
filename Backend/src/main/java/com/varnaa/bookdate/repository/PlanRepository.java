package com.varnaa.bookdate.repository;

import com.varnaa.bookdate.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface PlanRepository extends JpaRepository<Plan,String> {
}
