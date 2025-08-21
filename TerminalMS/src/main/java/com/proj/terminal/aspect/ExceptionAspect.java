package com.proj.terminal.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.proj.terminal.util.ErrorMessage;
import com.proj.terminal.exception.EmptyException;
import com.proj.terminal.exception.FailedException;
import com.proj.terminal.exception.NotFoundException;

@RestControllerAdvice
public class ExceptionAspect {
	
	@ExceptionHandler(EmptyException.class)
	public ResponseEntity<ErrorMessage> emptyException(EmptyException e){
		ErrorMessage error=new ErrorMessage();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		//error.setUrl("/product/id");
		ResponseEntity<ErrorMessage> entity=new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		return entity;
	}
	
	@ExceptionHandler(FailedException.class)
	public ResponseEntity<ErrorMessage> failedException(FailedException e){
		ErrorMessage error=new ErrorMessage();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		//error.setUrl("/product/id");
		ResponseEntity<ErrorMessage> entity=new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		return entity;
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorMessage> notFoundException(NotFoundException e){
		ErrorMessage error=new ErrorMessage();
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		//error.setUrl("/product/id");
		ResponseEntity<ErrorMessage> entity=new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		return entity;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> ExceptionHandling(Exception e){
		ResponseEntity<String> entity=new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		return entity;
	}
}
