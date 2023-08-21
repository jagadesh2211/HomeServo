package com.jsp.homeservo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.homeservo.dto.Customer;
import com.jsp.homeservo.dtodup.CustomerDuplicate;
import com.jsp.homeservo.service.CustomerService;
import com.jsp.homeservo.util.ResponseStructure;

@RestController
//@CrossOrigin(origins ="http://127.0.0.1:5500",
//methods = { RequestMethod.PUT, RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE} )
public class CustomerController {
	
		@Autowired
		private CustomerService service;
		
		@PostMapping("/customer")
		@CrossOrigin(origins = "http://127.0.0.1:5500")
		public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer){
			return service.saveCustomer(customer);
		}
		
		@PutMapping("/customer")
		public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer){
			return service.updateCustomer(customer);
		}
		
		@DeleteMapping("/customer")
		public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@RequestParam int id){
			return service.deleteCustomer(id);
		}
		
		@GetMapping("/customer/{id}")
		public ResponseEntity<ResponseStructure<CustomerDuplicate>> getCustomerById(@PathVariable int id){
			return service.getCustomerById(id);
		}
		
		@GetMapping("/customer")
		public ResponseEntity<ResponseStructure<Customer>> login(@RequestParam  String email,@RequestParam  String pwd){
			return service.login(email, pwd);
		}
}
