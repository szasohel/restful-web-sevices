package com.sayed.example.restfulwebsevices.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sayed.example.restfulwebsevices.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleuserNotFoundExceptions(UserNotFoundException ex, WebRequest request) {
		ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
	}
}
