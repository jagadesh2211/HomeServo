package com.jsp.homeservo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.homeservo.dao.AddressDao;
import com.jsp.homeservo.dto.Address;
import com.jsp.homeservo.util.ResponseStructure;

@Service
public class AddressService {
			
		@Autowired
		private AddressDao addressDao;
		
		public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address){
					Address db =addressDao.updateAddress(address);
					ResponseStructure<Address> structure=new ResponseStructure<Address>();
					if(db!=null) {
						structure.setData(addressDao.updateAddress(address));
						structure.setMessage("Data Updated SuccessFuly");
						structure.setStatus(HttpStatus.UPGRADE_REQUIRED.value());
						
						return new ResponseEntity<ResponseStructure<Address>> (structure,HttpStatus.UPGRADE_REQUIRED);
					}
					return null;
		}
		
		public ResponseEntity<ResponseStructure<Address>> getAddressById(int id){
					Address db =addressDao.findAddressById(id);
					
					ResponseStructure<Address> structure=new ResponseStructure<>();
					if(db!=null) {
						structure.setData(addressDao.findAddressById(id));
						structure.setMessage("Fetching The Id Is Found");
						structure.setStatus(HttpStatus.FOUND.value());
						
						return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
					}
					else {
						return null;
					}
		}
}
