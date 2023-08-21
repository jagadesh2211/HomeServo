package com.jsp.homeservo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.homeservo.dao.AddressDao;
import com.jsp.homeservo.dao.CustomerDao;
import com.jsp.homeservo.dao.ServiceCostDao;
import com.jsp.homeservo.dao.VendorDao;
import com.jsp.homeservo.dao.WorkDao;
import com.jsp.homeservo.dto.Customer;
import com.jsp.homeservo.dto.ServiceCost;
import com.jsp.homeservo.dto.Vendor;
import com.jsp.homeservo.dto.Work;
import com.jsp.homeservo.util.ResponseStructure;

import ch.qos.logback.core.util.Duration;

@Service
public class ServiceCostService {
	
	@Autowired
	private ServiceCostDao costDao;
	
	@Autowired
	private VendorDao vendorDao;
	
	@Autowired
	private WorkDao workDao;
	
	@Autowired
	private ServiceCost cost;
	
	@Autowired
	private CustomerDao customerDao;
	
	public ResponseEntity<ResponseStructure<ServiceCost>> saveCost(int w_id,int v_id){
		Vendor vendor =vendorDao.getVendorById(v_id);
		
		if(vendor!=null) {
		Work work 	= workDao.getWorkById(w_id);
		
		if(work!=null) {
			
			 double  costPerDay = vendor.getCostPerDay();
			 
			 Date start =work.getStartDate();
			 Date end =work.getEndDate();
			 
			 java.time.Duration duration =java.time.Duration.between(start.toLocalDate().atStartOfDay(), end.toLocalDate().atStartOfDay());
			 
			 int days = (int)duration.toDays();
			 
			 cost.setDays(days);
			 cost.setTotalAmount(days*costPerDay);
			 
			ServiceCost cost2 = costDao.saveServiceCost(cost);
			
			work.setCost(cost2);
			List<ServiceCost> list=new ArrayList<ServiceCost>(); 	
			list.add(cost2);
			list.addAll(vendor.getCosts());
			
			vendor.setCosts(list);
			vendorDao.UpdateVendor(vendor);
			workDao.UpdateWork(work);
			ResponseStructure<ServiceCost> structure=new ResponseStructure<ServiceCost>();
			structure.setData(cost2);
			structure.setMessage("Cost Saved Succesfully");
			structure.setStatus(HttpStatus.CREATED.value());
			
			return new ResponseEntity<ResponseStructure<ServiceCost>>(structure,HttpStatus.CREATED);
			
		}
		else {
			return null;
		}
		
		
		
		}
		else {
			return null;
		}
		
	}
	
	
	public ResponseEntity<ResponseStructure<ServiceCost>> payment(int c_id,ServiceCost serviceCost ){
		Customer customer = customerDao.getCustomerById(c_id);
		
		if(customer!=null) {
			    ServiceCost cost2 =costDao.getServiceCost(serviceCost.getId());
			    if(cost2!=null) {
			    	ResponseStructure<ServiceCost> structure=new ResponseStructure<ServiceCost>();
					structure.setData(costDao.payServiceCost(serviceCost));
					structure.setMessage("Cost Saved Succesfully");
					structure.setStatus(HttpStatus.CREATED.value());
					
					return new ResponseEntity<ResponseStructure<ServiceCost>>(structure,HttpStatus.CREATED);
			    }
			    else {
			    	return null;
			    }
		}
		else {
			return null;
		}
	}
		
}
