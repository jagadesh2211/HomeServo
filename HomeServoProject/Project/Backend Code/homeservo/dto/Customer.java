package com.jsp.homeservo.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Customer {
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int id;
			private String name;
			@Column(unique = true)
			private String email;
			private long phone;
			private String pwd;
			private int familyCount;
			
			@OneToOne(cascade = CascadeType.ALL)
			private Address address;
			
			@OneToMany(mappedBy = "customer")
			@JsonIgnore
			private List<Work> works;
}
