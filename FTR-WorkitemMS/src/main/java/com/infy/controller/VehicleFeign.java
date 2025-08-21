package com.infy.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.infy.dto.*;

@FeignClient(name="VehicleMS")//, url="https://localhost:3500/")
public interface VehicleFeign {
	
//	
//	https://localhost:8004/
//	WorkitemVehicleDTO fetchWorkItemDetailsByVehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber);	
	@GetMapping("ftr/vehicles")
	List<VehicleDTO> fetchAvailableVehicles();
	
	@GetMapping("ftr/vehicles/managed-number/{vehicleNumber}")
	VehicleDTO fetchVehicleDetailsByVehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber);
	
	@PutMapping("ftr/vehicles/{vehicleNumber}")
	String updateVehicleStatus(@PathVariable("vehicleNumber") String vehicleNumber,@RequestBody VehicleDTO vehicleDTO);
	

}
