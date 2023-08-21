package com.jsp.homeservo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.json.DupDetector;
import com.jsp.homeservo.dao.CustomerDao;
import com.jsp.homeservo.dto.Customer;
import com.jsp.homeservo.dtodup.CustomerDuplicate;
import com.jsp.homeservo.exception.DeleteIdNotFoundForCustomer;
import com.jsp.homeservo.exception.EmailNotFoundForCustomer;
import com.jsp.homeservo.exception.GetIdNotFoundForCustomer;
import com.jsp.homeservo.exception.PwdNotFoundForCustomer;
import com.jsp.homeservo.util.ResponseStructure;

import springfox.documentation.swagger2.mappers.ModelMapper;

@Service
public class CustomerService {
		@Autowired
		private CustomerDao dao;
		
		@Autowired
		ModelMapper mapper;
		
		@Autowired
		CustomerDuplicate duplicate;
		
		public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer){
			ResponseStructure<Customer> structure=new ResponseStructure<Customer>();
			structure.setData(dao.saveCustomer(customer));
			structure.setMessage("Customer Save Successfully");
			structure.setStatus(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure<Customer>> (structure,HttpStatus.CREATED);
		}
		
		public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer){
			
				Customer db =dao.getCustomerById(customer.getId());
			ResponseStructure<Customer> structure=new ResponseStructure<Customer>();
			if(db!=null) {
			
			structure.setData(dao.updateCustomer(customer));
			structure.setMessage(" Data Updated Successfully");
			structure.setStatus(HttpStatus.UPGRADE_REQUIRED.value());
			
			return new  ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.UPGRADE_REQUIRED);
			}
			else {
				return null;
			}
		}
		
		public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int id){
			Customer db =dao.deleteCustomer(id);
			ResponseStructure<Customer> structure=new ResponseStructure<Customer>();
			if(db!=null) {
			
			structure.setData(dao.deleteCustomer(id));
			structure.setMessage("Data Deleted Succesfully");
			structure.setStatus(HttpStatus.FOUND.value());
			
		
			
			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
			}
			else {
				throw new DeleteIdNotFoundForCustomer("Enter The Correct Id");
			}
		}
		
		
	public ResponseEntity<ResponseStructure<CustomerDuplicate>> getCustomerById(int id){
		Customer db =dao.getCustomerById(id);
		
		ResponseStructure<CustomerDuplicate> structure=new ResponseStructure<CustomerDuplicate>();
		if(db!=null) {
			
			
			
//			duplicate.setId(db.getId());
//			duplicate.setName(db.getName());
//			duplicate.setEmail(db.getEmail());
//			duplicate.setPhone(db.getPhone());
//			duplicate.setFamilyCount(db.getFamilyCount());
//			
//			structure.setData(duplicate);
//			structure.setMessage("Fetch the data Succesfully");
//			structure.setStatus(HttpStatus.FOUND.value());
//			
		
		return new ResponseEntity<ResponseStructure<CustomerDuplicate>>(structure,HttpStatus.FOUND);
		}
		else {
			throw new GetIdNotFoundForCustomer("Enter The Correct Id");
		}

	}
		
	public ResponseEntity<ResponseStructure<Customer>> login(String email,String pwd){
	Customer customer	= dao.getCustomerByEmail(email);
	
	if(customer !=null) {
		
		
		if(customer.getPwd().equals(pwd)) {
			ResponseStructure<Customer> structure=new ResponseStructure<Customer>();
			structure.setData(customer);
			structure.setMessage("Customer Login Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.FOUND);
		}
		else
			
			throw new PwdNotFoundForCustomer(" Give Correct Password....");
	}
	else
		
		throw new EmailNotFoundForCustomer(" Give Correct Email.....");
	
		
	}
}
