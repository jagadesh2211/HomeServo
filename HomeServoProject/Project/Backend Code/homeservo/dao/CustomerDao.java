package com.jsp.homeservo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.homeservo.dto.Customer;
import com.jsp.homeservo.repository.CustomerRepository;

@Repository
public class CustomerDao {
		
		@Autowired
		CustomerRepository customerRepository;
		
		public Customer saveCustomer(Customer customer) {
			return customerRepository.save(customer);
		}
		
		
		public Customer updateCustomer(Customer customer) {
			 	
			 if(customerRepository.findById(customer.getId()).isPresent()) {
				 Customer db =customerRepository.findById(customer.getId()).get();
				 
				 if(customer.getPwd()==null) {
					 customer.setPwd(db.getPwd());
				 }
				 if (customer.getPhone()==0) {
					customer.setPhone(db.getPhone());
				}
				 if (customer.getName()==null) {
					customer.setName(db.getName());
				}
				 if (customer.getFamilyCount()==0) {
					customer.setFamilyCount(db.getFamilyCount());
				}
				 if (customer.getEmail()==null) {
					customer.setEmail(db.getEmail());
				}
				 return customerRepository.save(customer);
			 }
			 else {
				 
			 return null;
			 }
		}
		
		public Customer deleteCustomer(int id) {
			 Optional<Customer> optional =customerRepository.findById(id);
			 
			 if(optional.isPresent()) {
				 
				 customerRepository.deleteById(id);
				 return optional.get();
			 }
			 else
			 {
			 return null;
			 }
		}
		
		public Customer getCustomerById(int id) {
			if(customerRepository.findById(id).isPresent()) {
				Customer customer =customerRepository.findById(id).get();
				return customer;
			}
			else {
				return null;
			}
		}
		
	public Customer getCustomerByEmail(String email) {
		Customer customer=customerRepository.findByEmail(email);
		
		if(customer!=null) {
			
			return customer;
			
		}
		else
			
			return null;
	}
		
		
		
		
		
}
