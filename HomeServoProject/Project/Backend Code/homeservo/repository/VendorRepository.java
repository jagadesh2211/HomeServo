package com.jsp.homeservo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.homeservo.dto.Vendor;

public interface VendorRepository  extends JpaRepository<Vendor, Integer>{
	
	public Vendor findByEmail(String email);
	

}
