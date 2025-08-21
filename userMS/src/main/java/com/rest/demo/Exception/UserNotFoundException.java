package com.rest.demo.Exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception{
	public UserNotFoundException(String msg) {
		super(msg);
	}
}
