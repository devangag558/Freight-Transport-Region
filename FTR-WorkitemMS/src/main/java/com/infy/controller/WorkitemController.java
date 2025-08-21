package com.infy.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.VehicleDTO;
import com.infy.dto.WorkitemDTO;
import com.infy.dto.WorkitemVehicleDTO;
import com.infy.service.WorkitemService;


@Validated
@RestController
public class WorkitemController {

	@Autowired
	WorkitemService service;
	
	@Autowired
	VehicleFeign vf;
	
	@GetMapping("ftr/workItems/{fromCountry}")
	public ResponseEntity<List<String>> fetchAvailableHarborLocations(@PathVariable("fromCountry") String country) throws Exception{
		return new ResponseEntity<List<String>>(service.fetchAvailableHarborLocations(country),HttpStatus.OK);
	}
	@GetMapping("ftr/workItems")
	public ResponseEntity<List<WorkitemDTO>> fetchWorkItemDetails() throws Exception{
		return new ResponseEntity<List<WorkitemDTO>>(service.fetchWorkItemDetails(),HttpStatus.OK);
	}
//	@GetMapping("ftr/workItems/managed-user/{userId}")
//	public ResponseEntity<List<WorkitemDTO>> fetchWorkItemByUser(@PathVariable("userId") Long userId) throws Exception{
//		return new ResponseEntity<List<WorkitemDTO>>(service.trackWorkitemStatusByUser(userId),HttpStatus.OK);
//	}
	
	@GetMapping("ftr/workItems/managed-user/{userId}")
	public ResponseEntity<List<WorkitemVehicleDTO>> fetchWorkItemByUser(@PathVariable("userId") Long userId) throws Exception{
		return new ResponseEntity<List<WorkitemVehicleDTO>>(service.trackWorkitemStatusByUser(userId),HttpStatus.OK);
	}
	
	@GetMapping("ftr/workItems/managed-status/{workitemId}")
	public ResponseEntity<WorkitemVehicleDTO> fetchWorkItemStatus(@PathVariable("workitemId") String workitemId) throws Exception{
		return new ResponseEntity<WorkitemVehicleDTO>(service.fetchWorkitemStatus(workitemId),HttpStatus.OK);
	}
	@GetMapping("ftr/workItems/managed-vehicle/{vehicleNumber}")
	public ResponseEntity<WorkitemVehicleDTO> fetchWorkItemDetailsByVehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber) throws Exception{
		return new ResponseEntity<WorkitemVehicleDTO>(service.fetchWorkitemDetailsByVehicleNumber(vehicleNumber),HttpStatus.OK);
	}
	@PostMapping("ftr/workItems")
	public ResponseEntity<WorkitemDTO> createWorkitem(@RequestBody WorkitemDTO w) throws Exception{
		return new ResponseEntity<WorkitemDTO>(service.createWorkitem(w),HttpStatus.OK);
	}
	
	@PutMapping("ftr/workItems/{workItemId}")
	public ResponseEntity<String> updateWorkItem(@PathVariable String workItemId, @RequestBody WorkitemDTO w) throws Exception{
		return new ResponseEntity<String>(service.updateWorkitemId(workItemId, w),HttpStatus.OK);
	}
	@PostMapping("ftr/workItems/managed-vehicle/{workItemId}")
	public ResponseEntity<String> allocateVehicle(@PathVariable String workItemId, @RequestBody VehicleDTO vehicleDTO) throws Exception{
		VehicleDTO v = vf.fetchVehicleDetailsByVehicleNumber(vehicleDTO.getVehicleNumber());
		String s = service.allocateVehicle(workItemId, v);
		vehicleDTO.setVehicleStatus("InProgress");
		vf.updateVehicleStatus(vehicleDTO.getVehicleNumber(), vehicleDTO);
		return new ResponseEntity<String>(s,HttpStatus.OK);
	}
	@PutMapping("ftr/workItems/managed-update/{workItemId}")
	public ResponseEntity<String> updateWorkItemStatus(@PathVariable String workItemId) throws Exception{
		List<WorkitemDTO> w = service.fetchWorkItemDetails();
		WorkitemDTO w2=null;
		for(WorkitemDTO i : w) {
			if (i.getWorkitemId().equalsIgnoreCase(workItemId)) {
				w2 = i;
				break;
			}
		}
		System.out.println(w2);
		if(w2==null)throw new Exception("Invalid Data");
		Date d = new Date();
		if(w2.getShippingDate().compareTo(d)<=0) {
			WorkitemVehicleDTO wv = service.fetchWorkitemStatus(workItemId);
			service.setStatusComplete(workItemId);
			VehicleDTO v = new VehicleDTO();
			v.setVehicleStatus("Active");
			System.out.println(v);
			vf.updateVehicleStatus(wv.getVehicleNumber(),v);
			return new ResponseEntity<String>("Work item status has been updated successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Invalid Data",HttpStatus.OK);
	}
	
	
	
	
//	@PostMapping("/ftr/vehicles")
//	public ResponseEntity<String> insertNewVehicle(@RequestBody @Valid VehicleDTO vehicleDTO) throws Exception{
//		service.insertNewVehicle(vehicleDTO);
//		return new ResponseEntity<String>("\"message\":"+"\"Vehicle details are inserted successfully with vehicle number:"+vehicleDTO.getVehicleNumber()+"\"",HttpStatus.OK);
//		
//	}
//	
//	@GetMapping("/ftr/vehicles")
//	public ResponseEntity<List<VehicleDTO>> fetchAvailableVehicles() throws Exception{
//		List<VehicleDTO> result = service.fetchAvailableVehicles();
//		for(VehicleDTO v:result) {
//		System.out.println(v);
//		}
//		return new ResponseEntity<>(result,HttpStatus.OK);
//	}
//	@PutMapping("ftr/vehicle/{vehicleNumber}")
//	public ResponseEntity<String> updateVehicleStatus(@RequestParam @Valid @Pattern(regexp="^[A-Za-z]{2}[0-9]{4}$", message="Invalid data") String vehicleNumber,@RequestBody @Valid VehicleDTO dto) throws Exception{
//		String result = service.updateVehicleStatus(vehicleNumber, dto);
//		return new ResponseEntity<>(result,HttpStatus.OK);
//	}
//	@GetMapping("ftr/vehicle//managed-name/{vehicleName}")
//	public ResponseEntity<List<VehicleDTO>> fetchVehicleDetailsByVehicleName(@RequestParam String vehicleName) throws Exception{
//		List<VehicleDTO> result = service.fetchVehicleDetailsByVehicleName(vehicleName);
//		for(VehicleDTO v:result) {
//		System.out.println(v);
//		}
//		return new ResponseEntity<>(result,HttpStatus.OK);
//	}
//	@CircuitBreaker(name = "", fallbackMethod="deleteFallback")
//	@DeleteMapping("ftr/vehicle/{vehicleNumber}")
//	public ResponseEntity<String> removeVehicle(@RequestParam String vehicleNumber) throws Exception{
//		//WorkitemVehicleDTO wdd = template.getForObject("http://{{WorkItemMS}}/ftr/workItems/managed-vehicle/"+ vehicleNumber, WorkitemVehicleDTO.class);
//		System.out.println("in method before feign call");
//		WorkitemVehicleDTO wdd = wf.fetchWorkItemDetailsByVehicleNumber(vehicleNumber);
//		System.out.println("in method after feign call");
//		if(wdd.getWorkItemStatus()=="Completed") {
//			String result = service.removeVehicle(vehicleNumber);
//			return new ResponseEntity<>(result,HttpStatus.OK);
//		}
//		else throw new Exception("Vehicle is assigned to incomplete work item");
//	}
//	public ResponseEntity<String> deleteFallback(String vehicleNumber, Throwable throwable){
//		System.out.println("in fallback");
//		return new ResponseEntity<>("Could not delete the vehicle WorkItem MS is not up",HttpStatus.OK);
//	}	
//	@GetMapping("ftr/vehicles/managed-number/{vehicleNumber}")
//	public ResponseEntity<VehicleDTO> fetchVehicleDetailsByVehicleNumber(@RequestParam @Valid @Pattern(regexp="^[A-Za-z]{2}[0-9]{4}$" , message="Invalid data") String vehicleNumber) throws Exception{
//		VehicleDTO result = service.fetchVehicleDetailsByVehicleNumber(vehicleNumber);
//		return new ResponseEntity<>(result,HttpStatus.OK);
//	}
	
	

}
