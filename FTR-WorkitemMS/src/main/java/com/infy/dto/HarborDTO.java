package com.infy.dto;

import com.infy.entity.Harbor;

public class HarborDTO {
	String country;
	String availableHarborLocation;
	public String getCountry() {
		return country;
	}
	public String getAvailableHarborLocation() {
		return availableHarborLocation;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setAvailableHarborLocation(String availableHarborLocation) {
		this.availableHarborLocation = availableHarborLocation;
	}
	public HarborDTO() {
		// TODO Auto-generated constructor stub
	}
	public static Harbor toEntity(HarborDTO h) {
		return new Harbor(h.getCountry(),h.getAvailableHarborLocation());
	}
	public HarborDTO(String country, String availableHarborLocation) {
		super();
		this.country = country;
		this.availableHarborLocation = availableHarborLocation;
	}
	@Override
	public String toString() {
		return "Harbor [country=" + country + ", availableHarborLocation=" + availableHarborLocation + "]";
	}
	
}
