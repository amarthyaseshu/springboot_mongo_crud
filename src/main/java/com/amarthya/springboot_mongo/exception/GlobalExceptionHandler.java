package com.amarthya.springboot_mongo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	// handling specific exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFoundException exception, WebRequest request) {
		return new ResponseEntity<>(new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false)),
				HttpStatus.NOT_FOUND);
	}

	// handling global exception

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request) {
		return new ResponseEntity<>(new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false)),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// handling annotation based validation errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> annotationBasedErrorHandling(MethodArgumentNotValidException exception) {
		return new ResponseEntity<>(new ErrorDetails(new Date(), "Annotation based error",
				exception.getBindingResult().getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
	}

}
