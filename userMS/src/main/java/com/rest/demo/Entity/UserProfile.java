package com.rest.demo.Entity;

import javax.persistence.*;

import com.rest.demo.DTO.UserProfileDTO;

@Entity
@Table(name="ftr_user")
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private Long mobileNumber;
	private String password;
	private String nationality;
	private String passportNumber;
	private String permanentAddress;
	private String officeAddress;
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
	
	public static UserProfileDTO convertToDTO(UserProfile user) {
		UserProfileDTO dto = new UserProfileDTO();
		dto.setUserId(user.getUserId());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setEmailId(user.getEmailId());
		dto.setMobileNumber(user.getMobileNumber());
		dto.setPassword(user.getPassword());
		dto.setNationality(user.getNationality());
		dto.setPassportNumber(user.getPassportNumber());
		dto.setPermanentAddress(user.getPermanentAddress());
		dto.setPersonalIdentificationNumber(user.getPersonalIdentificationNumber());
		
		return dto;
	}

}
