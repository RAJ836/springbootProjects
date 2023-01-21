package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.InvalidCredentialsException;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<Object> handleInvalidCredentials(InvalidCredentialsException ex){
		
		return new ResponseEntity<Object>(new InvalidCredentialsException(ex.getMessage()), HttpStatus.UNAUTHORIZED);
	}
}
