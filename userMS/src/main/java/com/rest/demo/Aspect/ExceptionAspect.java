package com.rest.demo.Aspect;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.rest.demo.Exception.*;

import com.rest.demo.Util.ErrorMessage;

@RestControllerAdvice
public class ExceptionAspect {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> UserNotFoundException(UserNotFoundException e){
		ErrorMessage errormsg = new ErrorMessage();
		errormsg.setErrorMessage(e.getMessage());
		errormsg.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errormsg.setUrl("ftr/userProfile/*");
		ResponseEntity<ErrorMessage> Response = new ResponseEntity<>(errormsg, HttpStatus.ACCEPTED);
		return Response;
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<Map<String,String>> MethodArgumentNotValidException(MethodArgumentNotValidException e){
		Map<String,String> error=new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach(err->{error.put(err.getField(), err.getDefaultMessage());});		
		ResponseEntity<Map<String,String>> Response = new ResponseEntity<>(error, HttpStatus.ACCEPTED);
		return Response;
	
  
	
	
}
}
