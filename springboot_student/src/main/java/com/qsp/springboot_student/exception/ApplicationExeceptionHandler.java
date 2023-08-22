package com.qsp.springboot_student.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.springboot_student.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExeceptionHandler extends ResponseEntityExceptionHandler {
	
	ResponseStructure<String> structure=new ResponseStructure<>();
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFoundException exception){
		structure.setMessage("Id Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> DataNotFoundHandler(DataNotFoundException exception) {
		structure.setMessage("Data Not Found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

	List<ObjectError> errors=	ex.getAllErrors();//will give you list of object errors
	
	Map<String, String> map=new LinkedHashMap<>();
	for (ObjectError objectError : errors) {
		//downcast
		FieldError error=(FieldError) objectError;
		String fieldName=((FieldError)objectError).getField();
		String message=error.getDefaultMessage();
		map.put(fieldName, message);
	}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}

}
