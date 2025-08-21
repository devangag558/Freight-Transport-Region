package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.dto.HarborDTO;

@Entity
@Table(name="ftr_harbor")
public class Harbor {
	@Id
	String country;
	String availableHarborLocations;
	public String getCountry() {
		return country;
	}
	public String getAvailableHarborLocation() {
		return availableHarborLocations;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setAvailableHarborLocation(String availableHarborLocation) {
		this.availableHarborLocations = availableHarborLocation;
	}
	public Harbor() {
		// TODO Auto-generated constructor stub
	}
	public static HarborDTO toDTO(Harbor h) {
		return new HarborDTO(h.getCountry(),h.getAvailableHarborLocation());
	}
	public Harbor(String country, String availableHarborLocation) {
		super();
		this.country = country;
		this.availableHarborLocations = availableHarborLocation;
	}
	@Override
	public String toString() {
		return "Harbor [country=" + country + ", availableHarborLocation=" + availableHarborLocations + "]";
	}
	
}
