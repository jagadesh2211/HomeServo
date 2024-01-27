package com.jsp.homeservo.exception;

import lombok.Data;

@Data
public class PwdNotFoundForCustomer extends RuntimeException {
		
	private String message="Pwd is Incorrect Plz Enter Correct Pwd";

	public PwdNotFoundForCustomer(String message) {
		super();
		this.message = message;
	}

	public PwdNotFoundForCustomer() {
		super();
	}
	
	
		
}
