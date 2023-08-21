package com.jsp.homeservo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.homeservo.dto.ServiceCost;
import com.jsp.homeservo.repository.ServiceCostRepository;

@Repository
public class ServiceCostDao {
				
			@Autowired
			private ServiceCostRepository costRepository;
			
	public ServiceCost saveServiceCost(ServiceCost cost) {
		return costRepository.save(cost);
	}
	
	public ServiceCost payServiceCost(ServiceCost cost) {
	ServiceCost cost2	=costRepository.findById(cost.getId()).get();
	
	if(cost2!=null) {
		cost2.setMode(cost.getMode());
		return costRepository.save(cost2);
	}
	else {
		return null;
	}
	}
	
	public ServiceCost getServiceCost(int id) {
		 ServiceCost serviceCost = costRepository.findById(id).get();
		 
		 if(serviceCost!=null) {
			 return serviceCost;
		 }
		 else {
			 return  null;
		 }
	}
	
}
