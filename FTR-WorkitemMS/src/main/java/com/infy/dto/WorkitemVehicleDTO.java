package com.infy.dto;

import com.infy.entity.WorkitemVehicle;

public class WorkitemVehicleDTO {
	String workitemId;
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
	public WorkitemVehicleDTO() {
		// TODO Auto-generated constructor stub
	}
	public static WorkitemVehicle toEntity(WorkitemVehicleDTO v) {
		return new WorkitemVehicle(v.getWorkitemId(),v.getVehicleNumber(),v.getDriverId(),v.getAssignedWorkitemStatus());
	}
	public WorkitemVehicleDTO(String workitemId, String vehicleNumber, String driverId, String assignedWorkitemStatus) {
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
