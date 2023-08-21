package com.jsp.homeservo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.homeservo.dao.VendorDao;
import com.jsp.homeservo.dto.Vendor;
import com.jsp.homeservo.exception.DeleteIdNotFoundForVendor;
import com.jsp.homeservo.util.ResponseStructure;

@Service
public class VendorService {
			
			@Autowired
			VendorDao vendorDao;
			
			public ResponseEntity<ResponseStructure<Vendor>> SaveVendor(Vendor vendor){
				ResponseStructure<Vendor> structure=new ResponseStructure<Vendor>();
				structure.setData(vendorDao.SaveVendor(vendor));
				structure.setMessage("Vendor Save SuccessFully...");
				structure.setStatus(HttpStatus.CREATED.value());
				
				return new ResponseEntity<ResponseStructure<Vendor>>(structure,HttpStatus.CREATED);
			} 
			 
			public ResponseEntity<ResponseStructure<Vendor>> updateVendor(Vendor vendor){
				Vendor db =vendorDao.getVendorById(vendor.getId());
				
				ResponseStructure<Vendor> structure=new ResponseStructure<Vendor>();
				if(db!=null) {
					structure.setData(vendorDao.UpdateVendor(vendor));
					structure.setMessage("Data Updated Successfully");
					structure.setStatus(HttpStatus.UPGRADE_REQUIRED.value());
					
					return new ResponseEntity<ResponseStructure<Vendor>> (structure,HttpStatus.UPGRADE_REQUIRED);
				}
				else {
					return null;
					
				}
				
			}
			
			public ResponseEntity<ResponseStructure<Vendor>> deleteVendorById(int id){
				Vendor db =vendorDao.deleteVendorById(id);
				
				ResponseStructure<Vendor> structure=new ResponseStructure<Vendor>();
				
				if(db!=null) {
					structure.setData(vendorDao.deleteVendorById(id));
					structure.setMessage("Data Deleted SuccessFully...");
					structure.setStatus(HttpStatus.FOUND.value());
					
					return new ResponseEntity<ResponseStructure<Vendor>>(structure,HttpStatus.FOUND);
				}
				else {
					throw new DeleteIdNotFoundForVendor("Deleting Id Not Found");
				}
			}
			
			public ResponseEntity<ResponseStructure<Vendor>> getVendorById(int id){
				Vendor db =vendorDao.getVendorById(id);
				
				ResponseStructure<Vendor> structure=new ResponseStructure<Vendor>();
				
				if(db!=null) {
					structure.setData(vendorDao.getVendorById(id));
					structure.setMessage("Fetching The Data Is Successfully Done..");
					structure.setStatus(HttpStatus.FOUND.value());
					
					return new ResponseEntity<ResponseStructure<Vendor>>(structure,HttpStatus.FOUND);
				}
				else {
					return null;//Custom exception class
				}
				
			}
			
			public ResponseEntity<ResponseStructure<Vendor>> login(String pwd,String email){
				 Vendor vendor = vendorDao.getVendorByEmail(email);
				 
				 if(vendor!=null) {
					 
					 if(vendor.getPwd().equals(pwd)) {
						 ResponseStructure<Vendor> structure=new ResponseStructure<Vendor>();
						 structure.setData(vendor);
						 structure.setMessage("Vendor Login Successfully...");
						 structure.setStatus(HttpStatus.FOUND.value());
						 
				return new ResponseEntity<ResponseStructure<Vendor>>(structure,HttpStatus.FOUND);

					 }
					 else {
						 return null;//pwd CEC
					 }
					 
				 }
				 else {
					 return null;//email CEC
				 }
			}
			
			public ResponseEntity<ResponseStructure<List<Vendor>>> getAllVendor(){
				
				ResponseStructure<List<Vendor>> structure=new ResponseStructure< List<Vendor>>();
				structure.setData(vendorDao.getAllVendor());
				structure.setMessage("Vendor details");
				structure.setStatus(HttpStatus.FOUND.value());
				
				
				return new  ResponseEntity<ResponseStructure<List<Vendor>>>(structure,HttpStatus.FOUND);
			}
			

}
