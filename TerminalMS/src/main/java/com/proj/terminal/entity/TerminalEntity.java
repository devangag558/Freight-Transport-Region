package com.proj.terminal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.proj.terminal.dto.TerminalDTO;

@Entity
@Table(name="ftr_terminals")
public class TerminalEntity {
	
	@Id
//	@GeneratedValue(generator="uuid")
//	@GenericGenerator(name="uuid",strategy="uuid2")
	private String terminalId;
	
	@Size(max=20,min=3,message="Terminal Name should be minimum of 3 characters and maximum of 20 characters.")
	private String terminalName;
	
	@Size(max=20,min=3,message="Country Name should be minimum of 3 characters and maximum of 20 characters.")
	private String country;
	
	@Size(max=30,min=4,message="Item type should be minimum of 4 characters and maximum of 30 characters.")
	private String itemType;
	
	@Size(max=25, message="Terminal Description should be maximum of 25 characters.")
//	@Pattern(regexp="[a-zA-Z0-9-a-zA-Z0-9]*$", message="Terminal Description is not in proper format - should be present.")
	private String terminalDescription;
	
	@Max(value=99999, message="Terminal Capacity is maximum of size 99999.")
	private Integer capacity;
	
	@Max(value=99999, message="Terminal AvailableCapacity is maximum of size 99999.")
	private Integer availableCapacity;
	
	@Pattern(regexp="^(Available|NotAvailable)$" , message="Terminal Status should be either \'Available\' or \'Not Available\'.")
	private String status;
	
	private String harborLocation;

	@Override
	public String toString() {
		return "TerminalEntity [terminalId=" + terminalId + ", terminalName=" + terminalName + ", country=" + country
				+ ", itemType=" + itemType + ", terminalDescription=" + terminalDescription + ", capacity=" + capacity
				+ ", Availablecapacity=" + availableCapacity + ", status=" + status + ", harborLocation="
				+ harborLocation + "]";
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getTerminalName() {
		return terminalName;
	}

	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getTerminalDescription() {
		return terminalDescription;
	}

	public void setTerminalDescription(String terminalDescription) {
		this.terminalDescription = terminalDescription;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getAvailablecapacity() {
		return availableCapacity;
	}

	public void setAvailablecapacity(Integer availablecapacity) {
		availableCapacity = availablecapacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHarborLocation() {
		return harborLocation;
	}

	public void setHarborLocation(String harborLocation) {
		this.harborLocation = harborLocation;
	}

	public TerminalEntity(String terminalId, String terminalName, String country, String itemType,
			String terminalDescription, Integer capacity, Integer availablecapacity, String status,
			String harborLocation) {
		super();
		this.terminalId = terminalId;
		this.terminalName = terminalName;
		this.country = country;
		this.itemType = itemType;
		this.terminalDescription = terminalDescription;
		this.capacity = capacity;
		availableCapacity = availablecapacity;
		this.status = status;
		this.harborLocation = harborLocation;
	}

	public TerminalEntity() {
		super();
	}
	
	public static TerminalDTO prepareTerminalDTO(TerminalEntity eDTO) {
		TerminalDTO eEntity = new TerminalDTO();
		eEntity.setTerminalId(eDTO.getTerminalId());
		eEntity.setTerminalName(eDTO.getTerminalName());
		eEntity.setCountry(eDTO.getCountry());
		eEntity.setItemType(eDTO.getItemType());
		eEntity.setTerminalDescription(eDTO.getTerminalDescription());
		eEntity.setCapacity(eDTO.getCapacity());
		eEntity.setAvailablecapacity(eDTO.getAvailablecapacity());
		eEntity.setStatus(eDTO.getStatus());
		eEntity.setHarborLocation(eDTO.getHarborLocation());
		return eEntity;
	}

}
