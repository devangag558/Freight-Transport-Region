package com.rest.demo.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rest.demo.DTO.LoginDTO;
import com.rest.demo.DTO.UpdateDTO;
import com.rest.demo.DTO.UserProfileDTO;
import com.rest.demo.Entity.Login;
import com.rest.demo.Entity.UserProfile;
import com.rest.demo.Exception.UserNotFoundException;
import com.rest.demo.Repository.UserProfileRepository;

@Service
@Transactional
public class UserProfileService implements UserProfileInterface {
	
	@Autowired
	UserProfileRepository userProfileRepo;
	
	public String createUser( UserProfileDTO dto){
		
		
		
		List<UserProfile> user = userProfileRepo.findByPersonalIdentificationNumber(dto.getPersonalIdentificationNumber());
		
		if(user.isEmpty())
		{
			UserProfile newUser = UserProfileDTO.convertToEntity(dto);
			userProfileRepo.save(newUser);
			return "Success";
		}
		else 
			return "User already present";
//		user=
//		userProfileRepo.save(null)
		
	}
	
	
	public String updateUser(int userId,UpdateDTO dto) throws UserNotFoundException{
		List<UserProfile> user = userProfileRepo.findByUserId(userId);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("can't find the details");
			
		}else {
			userProfileRepo.updatedetails(dto.getMobileNumber(),dto.getPermanentAddress(),dto.getOfficeAddress(), userId);
			return "updated successfully";
		}
		
		
	}
	
	
	
	public List<UserProfile>  getuserdetails(int userId) throws UserNotFoundException{
		//Collections.singletonList(UserProfile.convertToDTO(userProfileRepo.findByUserId(userId).get(0)));
		List<UserProfile> user = userProfileRepo.findByUserId(userId);
		if(user.isEmpty()) {
			throw new UserNotFoundException("User details not found.");
		}
		else {
		return user;
		}
					
	}
	
	public List<UserProfile>  getuserdetailsbyemail(String emailId) throws UserNotFoundException{
	
		List<UserProfile> user = userProfileRepo.findByEmailId(emailId);
		if(user.isEmpty()) {
			throw new UserNotFoundException("User details not found.");
		}
		else {
		return user;
		}
	}
	
	public String deleteUser(int userId) throws UserNotFoundException{
		List<UserProfile> user = userProfileRepo.findByUserId(userId);
		if(user.isEmpty())
			throw new UserNotFoundException("User details not found.");
		else {
			userProfileRepo.deleteById(userId);
			return "User " + userId + " details are removed successfully!";
		}
	}
	
	public String loginUser(LoginDTO dto) {
		
		List<UserProfile> user = userProfileRepo.findByEmailId(dto.getUserId());
		if(user.isEmpty())
		{
			System.out.println(dto);
			return "Invalid Username and Password";
		}
		else
		{
			
			for(UserProfile u : user) {
				
				Login newUser = LoginDTO.convertToEntity(dto);
				
				
				if(newUser.getPassword().equals(u.getPassword())) {
					
					return "Logged In Successfully!";
				}
				
			}
			return "Password is incorrect";
		}
		
	}

}
