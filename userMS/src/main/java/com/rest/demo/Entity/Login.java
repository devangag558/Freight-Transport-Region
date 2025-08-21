package com.rest.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.rest.demo.DTO.LoginDTO;


public class Login {
	
	
	private String userId;
	private String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", password=" + password + "]";
	}
	
	public static LoginDTO convertToDTO(Login log) {
		LoginDTO dto = new LoginDTO();
		dto.setUserId(log.getUserId());
		dto.setPassword(log.getPassword());
		return dto;
	}

}
