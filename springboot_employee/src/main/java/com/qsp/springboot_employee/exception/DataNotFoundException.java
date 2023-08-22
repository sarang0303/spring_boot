package com.qsp.springboot_employee.exception;

import net.bytebuddy.implementation.bind.annotation.Super;

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
