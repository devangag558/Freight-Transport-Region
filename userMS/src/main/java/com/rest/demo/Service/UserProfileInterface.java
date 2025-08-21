package com.rest.demo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rest.demo.DTO.LoginDTO;
import com.rest.demo.DTO.UpdateDTO;
import com.rest.demo.DTO.UserProfileDTO;
import com.rest.demo.Entity.UserProfile;
import com.rest.demo.Exception.UserNotFoundException;

public interface UserProfileInterface {
	
	public String createUser( UserProfileDTO dto);
	
	
	public String updateUser(int userId,UpdateDTO dto) throws UserNotFoundException;
	
	public List<UserProfile>  getuserdetails(int userId) throws UserNotFoundException;
	
	public List<UserProfile>  getuserdetailsbyemail(String emailId) throws UserNotFoundException;
	
	public String deleteUser(int userId) throws UserNotFoundException;
	
	public String loginUser(LoginDTO dto);

}
