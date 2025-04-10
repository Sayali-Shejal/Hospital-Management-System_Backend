package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalierException {
	@ExceptionHandler(value=NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleEmployeeException(NotFoundException exception) {
		
		
		return new ErrorMessage(HttpStatus.NOT_FOUND.value(),exception.getMessage());
		
	}

}
