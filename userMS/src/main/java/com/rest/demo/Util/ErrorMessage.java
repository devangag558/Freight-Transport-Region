package com.rest.demo.Util;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
	
	private Integer StatusCode;
	private String ErrorMessage;
	private String Url;
	private HttpStatus ErrorStatus;

	public HttpStatus getErrorStatus() {
		return ErrorStatus;
	}
	public void setErrorStatus(HttpStatus errorStatus) {
		ErrorStatus = errorStatus;
	}
	public Integer getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(Integer statusCode) {
		StatusCode = statusCode;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	


}
