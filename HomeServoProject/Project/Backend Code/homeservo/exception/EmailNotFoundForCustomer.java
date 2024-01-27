package com.jsp.homeservo.exception;

import lombok.Data;

@Data
public class EmailNotFoundForCustomer extends RuntimeException {
			
		private String message="Email is Not Found Plz Enter The Correct Email" ;

		public EmailNotFoundForCustomer(String message) {
			super();
			this.message = message;
		}

		public EmailNotFoundForCustomer() {
			super();
		}
		
		
	
}
