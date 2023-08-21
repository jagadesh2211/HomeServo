package com.jsp.homeservo.exception;

import lombok.Data;

@Data
public class DeleteIdNotFoundForVendor extends RuntimeException {
		
		private String msg="Deleting  the Object By Id is NOt Present";

		public DeleteIdNotFoundForVendor(String msg) {
			super();
			this.msg = msg;
		}

		public DeleteIdNotFoundForVendor() {
			super();
		}
		
		
		
}
