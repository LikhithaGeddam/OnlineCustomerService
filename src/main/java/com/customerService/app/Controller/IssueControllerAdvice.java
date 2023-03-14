package com.customerService.app.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.customerService.app.Exception.IssueException;
import com.customerService.app.Exception.OperatorIdNotFoundException;

@RestControllerAdvice
public class IssueControllerAdvice {
	
	@ExceptionHandler(IssueException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleIssueException(IssueException exception) 
	{
		return exception.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) 
	{
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();errors.put(fieldName, errorMessage);
			});
		return errors;
	}
	

}

