package com.infy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.dto.WorkitemVehicleDTO;

@Entity
@Table(name="ftr_vehicle_workitem")
public class WorkitemVehicle {
	@Id
	String workitemId;
	@Column(unique=true)
	String vehicleNumber;
	String driverId;
	String assignedWorkitemStatus;
	public String getWorkitemId() {
		return workitemId;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public String getDriverId() {
		return driverId;
	}
	public String getAssignedWorkitemStatus() {
		return assignedWorkitemStatus;
	}
	public void setWorkitemId(String workitemId) {
		this.workitemId = workitemId;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public void setAssignedWorkitemStatus(String assignedWorkitemStatus) {
		this.assignedWorkitemStatus = assignedWorkitemStatus;
	}
	public WorkitemVehicle() {
		// TODO Auto-generated constructor stub
	}
	public static WorkitemVehicleDTO toDTO(WorkitemVehicle v) {
		return new WorkitemVehicleDTO(v.getWorkitemId(),v.getVehicleNumber(),v.getDriverId(),v.getAssignedWorkitemStatus());
	}
	public WorkitemVehicle(String workitemId, String vehicleNumber, String driverId, String assignedWorkitemStatus) {
		super();
		this.workitemId = workitemId;
		this.vehicleNumber = vehicleNumber;
		this.driverId = driverId;
		this.assignedWorkitemStatus = assignedWorkitemStatus;
	}
	@Override
	public String toString() {
		return "VehicleWorkitem [workitemId=" + workitemId + ", vehicleNumber=" + vehicleNumber + ", driverId="
				+ driverId + ", assignedWorkitemStatus=" + assignedWorkitemStatus + "]";
	}
}
