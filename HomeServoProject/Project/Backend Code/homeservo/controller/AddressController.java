package com.jsp.homeservo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.homeservo.dto.Address;
import com.jsp.homeservo.service.AddressService;
import com.jsp.homeservo.util.ResponseStructure;

@RestController
public class AddressController {
			
			@Autowired
			private AddressService service;
			
	@PutMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> updateAddress( @RequestBody Address address){
		
		return service.updateAddress(address);
	}
	
	
	@GetMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> getAddressById( @RequestParam int id){
		return service.getAddressById(id);
	}
		
}
 
