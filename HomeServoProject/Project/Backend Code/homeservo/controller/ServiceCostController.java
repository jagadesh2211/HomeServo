package com.jsp.homeservo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.homeservo.dto.ServiceCost;
import com.jsp.homeservo.service.ServiceCostService;
import com.jsp.homeservo.util.ResponseStructure;

@RestController
public class ServiceCostController {
				
				@Autowired
				private ServiceCostService costService;
		
		@PostMapping("/save")
		public ResponseEntity<ResponseStructure<ServiceCost>> saveCost( @RequestParam int w_id,@RequestParam int v_id){
					return  costService.saveCost(w_id, v_id);
		}
		
		@PutMapping("/payment")
		public ResponseEntity<ResponseStructure<ServiceCost>> payment( @RequestParam int c_id,@RequestBody ServiceCost serviceCost){
			return costService.payment(c_id, serviceCost);
		}
	
	
}
