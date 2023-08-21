package com.jsp.homeservo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.homeservo.dto.Address;
import com.jsp.homeservo.repository.AddressRepository;

@Repository
public class AddressDao {
		
		@Autowired
		private AddressRepository repository;
		
		public Address updateAddress(Address address) {
		Address db	=repository.findById(address.getId()).get();
		
		if (db!=null) {
			if(address.getDoorNo()==0) {
				address.setDoorNo(db.getDoorNo());
			}
			if(address.getDistrict()==null) {
				address.setDistrict(db.getDistrict());
			}
			if(address.getState()==null) {
				address.setState(db.getState());
			}
			if(address.getStreet()==null) {
				address.setStreet(db.getStreet());
			}
			
			return repository.save(address);
		}
		else {
			return null;
		}
		
		}
		
		public Address findAddressById(int id) {
			
			if(repository.findById(id).isPresent()) {
			Address address =repository.findById(id).get();
			
			return address;
			
			}
			else {
				return null;
			}
			
		}
		
}
