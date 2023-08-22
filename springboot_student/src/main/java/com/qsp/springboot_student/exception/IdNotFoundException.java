package com.qsp.springboot_student.exception;

public class IdNotFoundException extends RuntimeException {
	String message;
	@Override
	
	public String getMessage() {
		return message;
	}
	
	
	public IdNotFoundException (String messgage) {
		super();
		this.message=messgage;
		
	}

}
