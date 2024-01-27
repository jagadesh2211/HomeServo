
package com.jsp.homeservo.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Address {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private int doorNo;
		private String street;
		private String district;
		private String state;
		private String landMark;
		private int pinCode;
		
		@OneToOne
		private Work works;
		
		@OneToOne
		private Vendor vendor;
}
