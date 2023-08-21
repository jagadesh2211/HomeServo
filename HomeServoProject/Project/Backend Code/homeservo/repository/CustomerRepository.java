package com.jsp.homeservo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.homeservo.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByEmail(String email);
	
}
