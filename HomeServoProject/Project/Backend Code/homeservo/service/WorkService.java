package com.jsp.homeservo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.homeservo.dao.CustomerDao;
import com.jsp.homeservo.dao.VendorDao;
import com.jsp.homeservo.dao.WorkDao;
import com.jsp.homeservo.dto.Customer;
import com.jsp.homeservo.dto.Vendor;
import com.jsp.homeservo.dto.Work;
import com.jsp.homeservo.exception.GetIdNotFoundForCustomer;
import com.jsp.homeservo.util.ResponseStructure;

@Service
public class WorkService {

	@Autowired
	private WorkDao workDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private VendorDao vendorDao;

	public ResponseEntity<ResponseStructure<Work>> saveWork(Work work, int cus_id) {
		Customer customer = customerDao.getCustomerById(cus_id);
		if (customer != null) {
			work.setCustomer(customer);
			ResponseStructure<Work> structure = new ResponseStructure<Work>();
			structure.setData(workDao.saveWork(work));
			structure.setMessage("Work Save Succesfuuly");
			structure.setStatus(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<Work>>(structure, HttpStatus.CREATED);
		} else {
			throw new GetIdNotFoundForCustomer("Id Not Found For customer");
		}
	}

	public ResponseEntity<ResponseStructure<Work>> startWork(int w_id, int ven_id) {
		Vendor vendor = vendorDao.getVendorById(ven_id);

		if (vendor != null) {
			Work work = workDao.getWorkById(w_id);

			if (work != null) {

				Date date = new Date(new java.util.Date().getTime());
				work.setStartDate(date);
				List<Vendor> list = new ArrayList<Vendor>();
				list.add(vendor);

				work.setVendors(list);

				ResponseStructure<Work> structure = new ResponseStructure<Work>();
				structure.setData(workDao.UpdateWork(work));
				structure.setMessage("Work Saved Successfully...");
				structure.setStatus(HttpStatus.CREATED.value());

				return new ResponseEntity<ResponseStructure<Work>>(structure, HttpStatus.CREATED);
		}
		else {
			return null;
		}
	}
		else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<Work>> endWork(int w_id, int ven_id) {
		Vendor vendor = vendorDao.getVendorById(ven_id);

		if (vendor != null) {
			Work work = workDao.getWorkById(w_id);

			if (work != null) {

				Date date = new Date(new java.util.Date().getTime());
				work.setEndDate(date);
				
				ResponseStructure<Work> structure = new ResponseStructure<Work>();
				structure.setData(workDao.UpdateWork(work));
				structure.setMessage("Work Saved Successfully...");
				structure.setStatus(HttpStatus.CREATED.value());

				return new ResponseEntity<ResponseStructure<Work>>(structure, HttpStatus.CREATED);
		}
		else {
			return null;
		}
	}
		else {
			return null;
		}
	}
	
	public ResponseEntity<ResponseStructure<Work>> getWorkById(int id){
	 Work db	= workDao.getWorkById(id);
	 
	 if(db!=null) {
		 ResponseStructure<Work> structure=new ResponseStructure<Work>();
		 
		 structure.setData(workDao.getWorkById(id));
		 structure.setMessage("Fetching Id Is Found");
		 structure.setStatus(HttpStatus.FOUND.value());
		 
		 return new ResponseEntity<ResponseStructure<Work>>(structure,HttpStatus.FOUND);
	 }
	 else {
		 return null;//exception cls
	 }
	}
	
	public ResponseEntity<ResponseStructure<List<Work>>> getAllWork(int v_id){
		Vendor vendor = vendorDao.getVendorById(v_id);
		
		if(vendor!=null) {
				ResponseStructure<List<Work>> structure=new ResponseStructure<List<Work>>();
				structure.setData(workDao.listOfWorks());
				structure.setMessage("List Of Works Found");
				structure.setStatus(HttpStatus.FOUND.value());
				
				return new ResponseEntity<ResponseStructure<List<Work>>>(structure,HttpStatus.FOUND);
		}
		else {
			return null;//Exception cls
		}
	}
}	
