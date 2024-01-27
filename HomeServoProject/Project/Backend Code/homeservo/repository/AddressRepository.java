package com.jsp.homeservo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.homeservo.dto.Address;

public interface AddressRepository  extends JpaRepository<Address, Integer>{

}
