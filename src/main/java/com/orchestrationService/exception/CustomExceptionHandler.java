package com.orchestrationService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<String> categoryNotFoundExceptionHandler(CategoryNotFoundException categoryNotFoundException){
		return new ResponseEntity<>(categoryNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(GoodownNotFoundException.class)
	public ResponseEntity<String> goodownNotFoundExceptionHandler(GoodownNotFoundException goodownNotFoundException){
		return new ResponseEntity<>(goodownNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> productNotFoundExceptionHandler(ProductNotFoundException productNotFoundException){
		return new ResponseEntity<>(productNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StoreNotFoundException.class)
	public ResponseEntity<String> storeNotFoundExceptionHandler(StoreNotFoundException storeNotFoundException){
		return new ResponseEntity<>(storeNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
	}

}
