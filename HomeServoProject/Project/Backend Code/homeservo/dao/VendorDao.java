package com.jsp.homeservo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.homeservo.dto.Vendor;
import com.jsp.homeservo.repository.VendorRepository;

@Repository
public class VendorDao {
			
			@Autowired
			VendorRepository vendorRepository;
	
		public Vendor SaveVendor(Vendor vendor) {
			return vendorRepository.save(vendor);
			
		}
		
		
		public Vendor UpdateVendor(Vendor vendor) {
			if(vendorRepository.findById(vendor.getId()).isPresent()) {
				Vendor db =vendorRepository.findById(vendor.getId()).get();
				
				if(vendor.getName()==null) {
					vendor.setName(db.getName());
				}
				if(vendor.getEmail()==null) {
					vendor.setEmail(db.getEmail());
				}
				if(vendor.getPwd()==null) {
					vendor.setPwd(db.getPwd());
				}
				if(vendor.getPhone()==0) {
					vendor.setPhone(db.getPhone());
				}
				if(vendor.getRole()==null) {
					vendor.setRole(db.getRole());
				}
				if(vendor.getCostPerDay()==0) {
					vendor.setCostPerDay(db.getCostPerDay());
				}
				return vendorRepository.save(vendor);
				
			}
			else {
				return null;
			}
		}
		
		
		public Vendor deleteVendorById(int id) {
			Optional<Vendor> optional =vendorRepository.findById(id);
			
			if(optional.isPresent()) {
				vendorRepository.deleteById(id);
				return optional.get();
			}
			else {
				return null;
			}
		}
		
		public Vendor getVendorById(int id) {
			if(vendorRepository.findById(id).isPresent()) {
				Vendor vendor =vendorRepository.findById(id).get();
				return vendor;
			}
			else {
				return null;
			}
		}
	
	public Vendor getVendorByEmail(String email) {
		Vendor vendor =vendorRepository.findByEmail(email);
		
		if(vendor!=null) {
			return vendor;
		}
		else {
			return null;
		}
		
	}
	
	public List<Vendor> getAllVendor(){
		return vendorRepository.findAll();
	}
	
}
