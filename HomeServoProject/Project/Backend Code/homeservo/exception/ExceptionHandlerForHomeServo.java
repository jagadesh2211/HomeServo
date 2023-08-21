package com.jsp.homeservo.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.homeservo.util.ResponseStructure;

@ControllerAdvice
public class ExceptionHandlerForHomeServo extends ResponseEntityExceptionHandler{
		
		@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
		public ResponseEntity<ResponseStructure<String>> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex){
			ResponseStructure<String> structure=new ResponseStructure<String>();
			structure.setMessage(ex.getMessage());
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setData("You Cant PerForm The Operation");
			
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(EmailNotFoundForCustomer.class)
		public ResponseEntity<ResponseStructure<String>> emailNotFoundForCustomer(EmailNotFoundForCustomer ex){
			ResponseStructure<String> structure=new ResponseStructure<String>();
			structure.setMessage(ex.getMessage());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(" Check Email Properly.......");
			
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(PwdNotFoundForCustomer.class)
		public ResponseEntity<ResponseStructure<String>> pwdNOtFoundForCustomer(PwdNotFoundForCustomer ex){
			ResponseStructure<String> structure=new ResponseStructure<String>(); 
			structure.setData("Check Pwd Properly....!!!");
			structure.setMessage(ex.getMessage());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);

		}
		
		@ExceptionHandler(DeleteIdNotFoundForCustomer.class)
		public ResponseEntity<ResponseStructure<String>> deleteIdNotFoundForCustomer(DeleteIdNotFoundForCustomer ref){
			ResponseStructure<String> structure=new ResponseStructure<String>();
			structure.setData("Check Id What U Given");
			structure.setMessage(ref.getMsg());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);

			
			
		}
		
		@ExceptionHandler(GetIdNotFoundForCustomer.class)
		public ResponseEntity<ResponseStructure<String>> getIdNotFoundForCustomer(GetIdNotFoundForCustomer ex){
			ResponseStructure<String> structure=new ResponseStructure<>();
			structure.setData("Check The Id What u Entered");
			structure.setMessage(ex.getMsg());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);

		}
		
		@ExceptionHandler(DeleteIdNotFoundForVendor.class)
		public ResponseEntity<ResponseStructure<String>> deleteIdNotFoundForVendor(DeleteIdNotFoundForVendor ex){
			ResponseStructure<String> structure=new ResponseStructure<>();
			structure.setData("Check Id what u given for Deleting");
			structure.setMessage(ex.getMsg());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);

		}
}
