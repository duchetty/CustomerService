package com.sbms.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ApiError> handleNotFoundException()
	{
		ApiError error=new ApiError(404,"Customer Doesn't Exist", new Date());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
				
	}
}
