package com.infy.repository;

//import java.util.Optional;
//import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Harbor;

public interface HarborRepository extends JpaRepository<Harbor, String> {
//	public Optional<List<Vehicle>> findByVehicleName(String vehicleName);

}
