package com.jsp.homeservo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.homeservo.dto.Vendor;
import com.jsp.homeservo.service.VendorService;
import com.jsp.homeservo.util.ResponseStructure;

@RestController
public class VendorController {
			
			@Autowired
			VendorService service;
			
			@PostMapping("/vendor")
			public ResponseEntity<ResponseStructure<Vendor>> SaveVendor( @RequestBody Vendor vendor){
				return service.SaveVendor(vendor);
			}
			
				
			@PutMapping("/vendor")
			public ResponseEntity<ResponseStructure<Vendor>> updateVendor( @RequestBody Vendor vendor){
					return service.updateVendor(vendor);
			}
			
			@DeleteMapping("/vendor")
			public ResponseEntity<ResponseStructure<Vendor>> deleteVendorById(@RequestParam int id){
				return service.deleteVendorById(id);
			}
			
			@GetMapping("/vendor/{id}")
			public ResponseEntity<ResponseStructure<Vendor>> getVendorById( @PathVariable int id){
				return service.getVendorById(id);
			}
			
			
			@GetMapping("/vendor/login")
			public ResponseEntity<ResponseStructure<Vendor>> login(String pwd,String email){
				return service.login(pwd, email);
			}
			
			
			@GetMapping("/vendor")
			public ResponseEntity<ResponseStructure<List<Vendor>>> getAllVendor(){
				return service.getAllVendor();
			}
}
