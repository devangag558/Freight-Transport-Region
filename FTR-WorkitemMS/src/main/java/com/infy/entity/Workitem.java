package com.infy.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.dto.WorkitemDTO;

@Entity
@Table(name="ftr_workitems")
public class Workitem {
	Long userId;
	@Id
	String workitemId;
	String itemName;
	String itemType;
	String itemDescription;
	String messageToRecipient;
	String quantity;
	String sourceCountry;
	String destinationCountry;
	String originHarborLocation;
	String selectedHarborLocation;
	Date shippingDate;
	Integer amount;
	public Long getUserId() {
		return userId;
	}
	public String getWorkitemId() {
		return workitemId;
	}
	public String getItemName() {
		return itemName;
	}
	public String getItemType() {
		return itemType;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public String getMessageToRecipient() {
		return messageToRecipient;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getSourceCountry() {
		return sourceCountry;
	}
	public String getDestinationCountry() {
		return destinationCountry;
	}
	public String getOrginHarborLocation() {
		return originHarborLocation;
	}
	public String getSelectedHarborLocation() {
		return selectedHarborLocation;
	}
	public Date getShippingDate() {
		return shippingDate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setWorkitemId(String workitemId) {
		this.workitemId = workitemId;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public void setMessageToRecipient(String messageToRecipient) {
		this.messageToRecipient = messageToRecipient;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setSourceCountry(String sourceCountry) {
		this.sourceCountry = sourceCountry;
	}
	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}
	public void setOrginHarborLocation(String orginHarborLocation) {
		this.originHarborLocation = orginHarborLocation;
	}
	public void setSelectedHarborLocation(String selectedHarborLocation) {
		this.selectedHarborLocation = selectedHarborLocation;
	}
	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public static WorkitemDTO toDTO(Workitem w) {
		return new WorkitemDTO(w.getUserId(),w.getWorkitemId(),w.getItemName(),w.getItemType(),w.getItemDescription(),
				w.getMessageToRecipient(),w.getQuantity(),w.getSourceCountry(),w.getDestinationCountry(),
				w.getOrginHarborLocation(),w.getSelectedHarborLocation(),w.getShippingDate(),w.getAmount());
	}
	public Workitem(Long userId, String workitemId, String itemName, String itemType, String itemDescription,
			String messageToRecipient, String quantity, String sourceCountry, String destinationCountry,
			String orginHarborLocation, String selectedHarborLocation, Date shippingDate, Integer amount) {
		super();
		this.userId = userId;
		this.workitemId = workitemId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemDescription = itemDescription;
		this.messageToRecipient = messageToRecipient;
		this.quantity = quantity;
		this.sourceCountry = sourceCountry;
		this.destinationCountry = destinationCountry;
		this.originHarborLocation = orginHarborLocation;
		this.selectedHarborLocation = selectedHarborLocation;
		this.shippingDate = shippingDate;
		this.amount = amount;
	}
	public Workitem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
