package com.infy.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.WorkitemVehicle;

public interface WorkitemVehicleRepository extends JpaRepository<WorkitemVehicle, String> {
//	public Optional<List<Vehicle>> findByVehicleName(String vehicleName);
	public Optional<WorkitemVehicle> findByVehicleNumber(String vehicleNumber);
	

}
