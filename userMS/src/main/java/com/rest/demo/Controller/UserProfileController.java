package com.rest.demo.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.DTO.LoginDTO;
import com.rest.demo.DTO.UpdateDTO;
import com.rest.demo.DTO.UserProfileDTO;
import com.rest.demo.Entity.UserProfile;
import com.rest.demo.Exception.UserNotFoundException;
import com.rest.demo.Service.UserProfileService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin()
@RestController
@RequestMapping("ftr/userProfile")
public class UserProfileController {
	
	@Autowired
	UserProfileService userProfileService;
	
	@PostMapping
	public ResponseEntity<String> createUser (@RequestBody @Valid UserProfileDTO dto ){
		
		String msg = userProfileService.createUser(dto);
		if(msg == "Success") {
			 ResponseEntity<String> response = new ResponseEntity<>(dto.toString(),HttpStatus.ACCEPTED);
			 return response;
		}
		else {
			 ResponseEntity<String> response = new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
			 return response;
		}
		
	}

	
	@PutMapping("/{userid}")
	public ResponseEntity<String> updateUser(@PathVariable("userid") int userId,@RequestBody @Valid  UpdateDTO dto ) throws Exception{
		String msg = userProfileService.updateUser(userId,dto);
		if(msg=="updated successfully") {
			ResponseEntity<String> response = new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
			 return response;
		}else {
			 ResponseEntity<String> response = new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
			 return response;
			
		}
	
	}
	
	// get by userId
	@GetMapping("/{userid}")
	public ResponseEntity<List<UserProfile>> getUser(@PathVariable("userid") int userId) throws Exception{
		List<UserProfile> details = userProfileService.getuserdetails(userId);
		
			
		ResponseEntity<List<UserProfile>> response = new ResponseEntity<>(details,HttpStatus.ACCEPTED);
		return response;
		
	}
	
	//get by email id
	@GetMapping("/email/{emailid}")
	public ResponseEntity<List<UserProfile>> getUserbymail(@PathVariable("emailid") String emailid) throws Exception{
		
		
		List<UserProfile> details = userProfileService.getuserdetailsbyemail(emailid);
		
		ResponseEntity<List<UserProfile>> response = new ResponseEntity<>(details,HttpStatus.ACCEPTED);
		return response;
		
	}
	
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<String> deleteUser(@PathVariable("userid") int userId) throws UserNotFoundException{
		String msg = userProfileService.deleteUser(userId);
		if(msg=="User Not Found") {
			ResponseEntity<String> response = new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
			return response;
		}
		else
		{
			ResponseEntity<String> response = new ResponseEntity<>(msg,HttpStatus.FOUND);
			return response;
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO dto){
		
		String msg = userProfileService.loginUser(dto);
		if(msg=="Invalid Username and Password") {
			ResponseEntity<String> response = new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
			return response;
		}
		else {
			ResponseEntity<String> response = new ResponseEntity<>(msg,HttpStatus.ACCEPTED);
			return response;
		}
		
	}
	

}
