package com.customerService.app.Controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.customerService.app.Exception.DepartmentIdNotFoundException;
import com.customerService.app.Exception.NoOperatorsListFoundException;
import com.customerService.app.Exception.OperatorException;
import com.customerService.app.Exception.OperatorIdNotFoundException;

@RestControllerAdvice
public class OperatorControllerAdvice {
	
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
	
	@ExceptionHandler(NoOperatorsListFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleNoOperatorsListFoundException(NoOperatorsListFoundException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(DepartmentIdNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleDepartmentIdNotFoundException(DepartmentIdNotFoundException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(OperatorIdNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleOperatorIdNotFoundException(OperatorIdNotFoundException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(OperatorException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleOperatorException(OperatorException e) {
		return e.getMessage();
	}

}
