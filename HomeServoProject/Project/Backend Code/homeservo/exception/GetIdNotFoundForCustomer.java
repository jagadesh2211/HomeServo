package com.jsp.homeservo.exception;

import lombok.Data;

@Data
public class GetIdNotFoundForCustomer extends RuntimeException {

	private	String msg="Fetching The Object By Is Not Present Check The Id";

		public GetIdNotFoundForCustomer(String msg) {
			super();
			this.msg = msg;
		}

		public GetIdNotFoundForCustomer() {
			super();
		}
		
		
			
}
