package com.jsp.homeservo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.homeservo.dto.Work;
import com.jsp.homeservo.repository.WorkRepository;

@Repository
public class WorkDao {
		
		@Autowired
		WorkRepository workRepository;
		
		public Work saveWork(Work work) {
			return workRepository.save(work);
		}
		
		public Work getWorkById(int id) {
			if(workRepository.findById(id).isPresent()) {
				Work  work =workRepository.findById(id).get();
				
				return work;
			}
			else {
				return null;
			}
		}
		
		public List<Work> listOfWorks(){
			List<Work> list=workRepository.listworks();
			
			if(list!=null) {
				return list;
			}
			else {
				return null;
			}
		}

		
		public Work UpdateWork(Work work) {
			if(workRepository.findById(work.getId()).isPresent()) {
					Work db =workRepository.findById(work.getId()).get();
					
					if(work.getAddress()==null) {
						work.setAddress(db.getAddress());
					}
					if(work.getCost()==null) {
						work.setCost(db.getCost());
					}
					if(work.getCustomer()==null) {
						work.setCustomer(db.getCustomer());
					}
					if(work.getVendors()==null) {
						work.setVendors(db.getVendors());
					}
					
					if(work.getWorkType()==null) {
						work.setWorkType(db.getWorkType());
					}
					if(work.getStartDate()==null) {
						work.setStartDate(db.getStartDate());
					}
					if(work.getEndDate()==null) {
						work.setEndDate(db.getEndDate());;
					}
					return workRepository.save(work);
			}
			else {
				return null;
			}
		}
		
}
