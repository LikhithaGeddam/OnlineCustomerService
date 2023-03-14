package com.customerService.app.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.customerService.app.Exception.CustomerException;

@RestControllerAdvice
public class CustomerControllerAdvice {
	
	@ExceptionHandler(CustomerException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public String handleCustomerException(CustomerException exception)
	{
		return exception.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(MissingRequestCookieException.class)
	public String loginExceptionHandler(MissingRequestCookieException e) {
		//return e.getMessage();
		return "Please login, you are unauthorised!";
	}
}