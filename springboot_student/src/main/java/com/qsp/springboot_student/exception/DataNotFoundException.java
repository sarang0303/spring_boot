package com.qsp.springboot_student.exception;

public class DataNotFoundException extends RuntimeException {
	String message;
	@Override
	public String getMessage() {
		return message;
	}
	
	public DataNotFoundException (String message) {
		super();
		this.message=message;
		
	}

}
