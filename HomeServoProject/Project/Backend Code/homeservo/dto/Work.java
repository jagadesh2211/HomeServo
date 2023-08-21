package com.jsp.homeservo.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
@Entity
public class Work {
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int id;
			private String workType;
			private  Date startDate;
			private  Date endDate;
			
			@OneToOne(cascade =CascadeType.ALL)
			private Address address;
			
			@ManyToOne
			@JoinColumn
			private Customer customer;
			
			@ManyToMany
			private List<Vendor> vendors;
			
			@OneToOne
			private ServiceCost cost;
			
			
			
			
			
			
			
}
