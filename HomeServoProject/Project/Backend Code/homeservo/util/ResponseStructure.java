package com.jsp.homeservo.util;

import java.util.List;

import com.jsp.homeservo.dto.Vendor;

import lombok.Data;

@Data
public class ResponseStructure<T> {
			
		private String message;
		private int status;
		private T data;
}
