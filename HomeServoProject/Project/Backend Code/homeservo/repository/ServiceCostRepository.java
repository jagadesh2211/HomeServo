package com.jsp.homeservo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.homeservo.dto.ServiceCost;

public interface ServiceCostRepository extends JpaRepository<ServiceCost, Integer> {

}
