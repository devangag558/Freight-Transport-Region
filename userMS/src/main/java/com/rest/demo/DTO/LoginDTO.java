package com.rest.demo.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.rest.demo.Entity.Login;

public class LoginDTO {
	
	private String userId;
	@NotEmpty(message="Password must not be Empty")
	//@Size(min=7,max=15,message="{user.password.invalidsize}")
	//@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="{user.password.invalid}")
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{7,15})",message="Password is invalid")
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
	
	public static Login convertToEntity(LoginDTO dto) {
		Login log = new Login();
		log.setUserId(dto.getUserId());
		log.setPassword(dto.getPassword());
		return log;
	}

}
