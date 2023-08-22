package com.qsp.springboot_employee.exception;

public class IdNotFoundException extends RuntimeException {
	String message;
	@Override
	public String getMessage() {
		return message;
	}
	
	public IDNotFoundException (String message) {
		super();
		this.message=message;
		
	}

}
