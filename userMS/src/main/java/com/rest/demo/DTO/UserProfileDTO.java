package com.rest.demo.DTO;

import javax.validation.constraints.*;

import com.rest.demo.Entity.UserProfile;

public class UserProfileDTO {
	
	
	private int userId;
	
	@NotEmpty(message="FirstName Must not be Empty")
	@NotNull(message="FirstNmae must not be null")
	@Size(min=2,max=20, message="Minimum 2 and Maximum 20 Characters required")
	private String firstName;
	
	@NotEmpty(message="LastName Must not be Empty")
	@Size(min=2,max=20,message="Minimum 2 and Maximum 20 Characters required")
	private String lastName;
	
	@NotEmpty(message="Email must not be Empty")
	@Email(message="Invalid Email Address")
	private String emailId;
	
	@NotNull(message="PhoneNumber must not be Empty")
	@Min(value=1111111111L,message="PhoneNumber must be 10 digits")
	@Max(value=9999999999L,message="PhoneNumber must be 10 digits")
	private Long mobileNumber;
	
	@NotEmpty(message="Password must not be Empty")
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{7,15})",message="Password is invalid")
	private String password;
	
	@NotEmpty(message="Nationality must not be Empty")
	@Size(max=20,message="Maximum 20 Characters are allowed")
	private String nationality;
	
	@NotEmpty(message="PassportNumber must not be Empty")
	@Size(min=7,max=12,message="Minimum 7 and Maximum 12 Characters required")
	private String passportNumber;
	
	@NotEmpty(message="permanentAddress must not be Empty")
	@Size(max=200,message="Maximum 200 characters are only allowed")
	private String permanentAddress;
	
	@NotEmpty(message="OfficeAddress must not be Empty")
	@Size(max=200,message="Maximum 200 characters are only allowed")
	private String officeAddress;
	
	@NotNull(message="PersonalIdentificationNumber Must not be Empty")
	@Min(value=111111111111L,message="personalIdentificationNumber must be 12 digits")
	@Max(value=999999999999L,message="personalIdentificationNumber must be 12 digits")
	private Long personalIdentificationNumber;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "UserProfileDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", mobileNumber=" + mobileNumber + ", password=" + password + ", nationality=" + nationality
				+ ", passportNumber=" + passportNumber + ", permanentAddress=" + permanentAddress + ", officeAddress="
				+ officeAddress + ", personalIdentificationNumber=" + personalIdentificationNumber + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public Long getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}
	public void setPersonalIdentificationNumber(Long personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}
	
	public static UserProfile convertToEntity(UserProfileDTO dto) {
		UserProfile user = new UserProfile();
		user.setUserId(dto.getUserId());
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmailId(dto.getEmailId());
		user.setMobileNumber(dto.getMobileNumber());
		user.setPassword(dto.getPassword());
		user.setOfficeAddress(dto.getOfficeAddress());
		user.setNationality(dto.getNationality());
		user.setPassportNumber(dto.getPassportNumber());
		user.setPermanentAddress(dto.getPermanentAddress());
		user.setPersonalIdentificationNumber(dto.getPersonalIdentificationNumber());
		
		return user;
	}
	
	

}
