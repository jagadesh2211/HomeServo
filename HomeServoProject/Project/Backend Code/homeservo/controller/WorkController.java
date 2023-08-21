package com.jsp.homeservo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.homeservo.dto.Work;
import com.jsp.homeservo.service.WorkService;
import com.jsp.homeservo.util.ResponseStructure;

@RestController
public class WorkController {
			
		
		@Autowired
		private WorkService service;
		
		@PostMapping("/work")
		public ResponseEntity<ResponseStructure<Work>> saveWork( @RequestBody Work work, @RequestParam  int cus_id){
			
			return service.saveWork(work, cus_id);
		}
		
			
		@PutMapping("/start")
		public ResponseEntity<ResponseStructure<Work>> startWork( @RequestParam  int w_id, @RequestParam int ven_id){
			return service.startWork(w_id, ven_id);
			
		}
		
		@PutMapping("/end")
		public ResponseEntity<ResponseStructure<Work>> endWork( @RequestParam int w_id, @RequestParam int ven_id){
			return service.endWork(w_id, ven_id);
		}
		
		@GetMapping("/work/{id}")
		public ResponseEntity<ResponseStructure<Work>> getWorkById( @PathVariable int id){
			return service.getWorkById(id);
		}
		
		
		@GetMapping("work/all")
		public ResponseEntity<ResponseStructure<List<Work>>> getAllWork( @RequestParam int v_id){
			return service.getAllWork(v_id);
		}
}
