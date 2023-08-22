package com.qsp.springboot_employee.exception;

public class EmailNotFoundException  extends RuntimeException{
	String message;
	
	public String getMessage() {
		return message;
		
	}
	
	public EmailNotFoundException (String message) {
		super();
		this.message=message;
		
	}

}
