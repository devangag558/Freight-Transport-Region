package com.rest.demo.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateDTO {
	
	@NotNull(message="PhoneNumber must not be Empty")
	@Min(value=1111111111L,message="PhoneNumber must be 10 digits")
	@Max(value=9999999999L,message="PhoneNumber must be 10 digits")
	private Long mobileNumber;
	
	@NotEmpty(message="permanentAddress must not be Empty")
	@Size(max=200,message="Maximum 200 characters are only allowed")
	private String permanentAddress;
	
	@NotEmpty(message="OfficeAddress must not be Empty")
	@Size(max=200,message="Maximum 200 characters are only allowed")
	private String officeAddress;

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	@Override
	public String toString() {
		return "UpdateDTO [mobileNumber=" + mobileNumber + ", permanentAddress=" + permanentAddress + ", officeAddress="
				+ officeAddress + "]";
	}

}
