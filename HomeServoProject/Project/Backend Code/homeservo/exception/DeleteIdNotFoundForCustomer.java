package com.jsp.homeservo.exception;

import lombok.Data;

@Data
public class DeleteIdNotFoundForCustomer extends RuntimeException {
			
	private String msg="Deleting  the Object By Id is NOt Present Plz";

	public DeleteIdNotFoundForCustomer(String msg) {
		super();
		this.msg = msg;
	}

	public DeleteIdNotFoundForCustomer() {
		super();
	}
	
	
}
