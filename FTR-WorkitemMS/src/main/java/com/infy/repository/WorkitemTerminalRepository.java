package com.infy.repository;

//import java.util.Optional;
//import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.WorkitemTerminal;

public interface WorkitemTerminalRepository extends JpaRepository<WorkitemTerminal, String> {
//	public Optional<List<Vehicle>> findByVehicleName(String vehicleName);

}
