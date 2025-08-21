package com.infy.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.repository.*;
import com.infy.entity.*;
import com.infy.dto.*;
import com.infy.exception.*;

@Service
@Transactional
public class WorkitemService {

	@Autowired
	HarborRepository hr;
	@Autowired
	WorkitemVehicleRepository wvr;
	@Autowired
	WorkitemRepository wr;
	@Autowired
	WorkitemTerminalRepository wtr;
	
	
	
	
	
	public WorkitemDTO createWorkitem(WorkitemDTO workitemDTO) throws Exception{
		Optional<Workitem> obj1 = wr.findById(workitemDTO.getWorkitemId());
		if(!obj1.isPresent()) {
			wr.saveAndFlush(WorkitemDTO.toEntity(workitemDTO));
			return workitemDTO;
		}
		else throw new Exception("Workitem already present");
	}
	
	public String updateWorkitemId(String workitemId,WorkitemDTO workitemDTO) throws Exception{
		Optional<Workitem> obj1 = wr.findById(workitemId);
		if(obj1.isPresent()) {
			Workitem w = obj1.get();
			w.setShippingDate(workitemDTO.getShippingDate());
			w.setOrginHarborLocation(workitemDTO.getOrginHarborLocation());
//			wr.saveAndFlush(WorkitemDTO.toEntity(workitemDTO));
			return "Workitem details are successfully updated";
		}
		else throw new WORKITEM_NOT_FOUND();
	}
	public List<String> fetchAvailableHarborLocations(String country) throws Exception {
		Optional<Harbor> obj1 = hr.findById(country);
		if(obj1.isPresent()) {
			Harbor h = obj1.get();
			String s = h.getAvailableHarborLocation();
			List<String> li = new ArrayList<String>(Arrays.asList(s.split(",")));
			return li;
		}
		throw new Exception("Harbor locations for the given country are not available");
	}
	public List<WorkitemDTO> fetchWorkItemDetails(){
		List<Workitem> lw = wr.findAll();
		List<WorkitemDTO> lwd = new ArrayList<WorkitemDTO>();
		for(Workitem w : lw) {
			lwd.add(Workitem.toDTO(w));
		}
		return lwd;
	}
//	public List<WorkitemDTO> trackWorkitemStatusByUser(Long userId) throws Exception{
//		Optional<List<Workitem>> obj1 = wr.findByUserId(userId);
//		if(obj1.isPresent()) {
//			List<Workitem> lw = obj1.get();
//			List<WorkitemDTO> lwd = new ArrayList<WorkitemDTO>();
//			for(Workitem w : lw) {
//				lwd.add(Workitem.toDTO(w));
//			}
//			return lwd;
//		}
//		throw new Exception("No Work Item found for this User Id");
//	}
	
	public List<WorkitemVehicleDTO> trackWorkitemStatusByUser(Long userId) throws Exception{
		Optional<List<Workitem>> obj1 = wr.findByUserId(userId);
		if(obj1.isPresent()) {
			List<Workitem> lw = obj1.get();
			List<WorkitemVehicleDTO> lwd = new ArrayList<WorkitemVehicleDTO>();
			for(Workitem w : lw) {
				Optional<WorkitemVehicle> obj2 = wvr.findById(w.getWorkitemId());
				if(obj2.isPresent()) lwd.add(WorkitemVehicle.toDTO(obj2.get()));			}
			return lwd;
		}
		throw new Exception("No Work Item found for this User Id");
	}
	
	public WorkitemVehicleDTO fetchWorkitemStatus(String workitemId) throws Exception{
		Optional<WorkitemVehicle> obj1 = wvr.findById(workitemId);
		if(obj1.isPresent()) {
			return WorkitemVehicle.toDTO(obj1.get());
		}
		throw new Exception("Workitem details not found for given workitem id");
	}
	public WorkitemVehicleDTO fetchWorkitemDetailsByVehicleNumber(String vehicleNumber) throws Exception {
		Optional<WorkitemVehicle> obj1 = wvr.findByVehicleNumber(vehicleNumber);
		if(obj1.isPresent()) {
			return WorkitemVehicle.toDTO(obj1.get());
		}
		else return null;
//		throw new Exception("Workitem details not found for given vehicle number");
	}
	
	public String allocateVehicle(String workitemId, VehicleDTO v2) throws Exception {
		Optional<Workitem> obj1 = wr.findById(workitemId);
		if(obj1.isPresent()) {
			Optional<WorkitemVehicle> obj2 = wvr.findById(workitemId);
			if(obj2.isEmpty()) {
				if(v2.getVehicleStatus().equalsIgnoreCase("Active")) {
//					VehicleDTO v = this.findVehicleForWorkitem(workitemId, v2);
					WorkitemVehicle wv = new WorkitemVehicle(workitemId,v2.getVehicleNumber(),"D116","InProgress");
					wvr.saveAndFlush(wv);
					return "Workitem is allocated with Vehicle successfully.";
				}
				throw new Exception("Vehicle is not Active");
			}
			throw new WORKITEM_VEHICLE_ALLOCATED();
		}
		throw new WORKITEM_NOT_FOUND();
	}
	
	public VehicleDTO findVehicleForWorkitem(String workitemId, List<VehicleDTO> vdl) throws Exception {
		Optional<Workitem> obj1 = wr.findById(workitemId);
		if(obj1.isPresent()) {
			Optional<WorkitemVehicle> obj2 = wvr.findById(workitemId);
			if(obj2.isEmpty()) {
				for(VehicleDTO v:vdl) {
					Optional<WorkitemVehicle> obj3 = wvr.findByVehicleNumber(v.getVehicleNumber());
					if (obj3.isEmpty()) {
						return v;
					}
					throw new Exception("Vehicle not available.");
				}
			}
			throw new WORKITEM_VEHICLE_ALLOCATED();
		}
		throw new WORKITEM_NOT_FOUND();
		
	}
	public void setStatusComplete(String workitemId) {
		Optional<WorkitemVehicle> obj1 = wvr.findById(workitemId);
		if(obj1.isPresent()) {
			obj1.get().setAssignedWorkitemStatus("Completed");
		}
	}
	
//	public List<VehicleDTO> fetchAvailableVehicles() throws Exception{
//		Optional<List<Vehicle>> obj1 = Optional.of(vr.findAll());
//		if(obj1.isPresent()) {
//			List<Vehicle> li = obj1.get();
//			List<VehicleDTO> li2 = new ArrayList<VehicleDTO>();
//			System.out.println(li);
//			for(Vehicle v : li) {
//				System.out.println(v);
//				li2.add(Vehicle.toDTO(v));
//			}
//			return li2;
//		}
//		else throw new Exception("Invalid Data");
//	}
//	public List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws Exception{
//		Optional<List<Vehicle>> obj1 = vr.findByVehicleName(vehicleName);
//		if(obj1.isPresent()) {
//			List<Vehicle> li = obj1.get();
//			List<VehicleDTO> li2 = new ArrayList<VehicleDTO>();
//			System.out.println(li);
//			for(Vehicle v : li) {
//				System.out.println(v);
//				li2.add(Vehicle.toDTO(v));
//			}
//			return li2;
//		}
//		else throw new Exception("Invalid Data");
//	}
//	public VehicleDTO fetchVehicleDetailsByVehicleNumber(String vehicleNumber) throws Exception{
//		Optional<Vehicle> obj1 = vr.findById(vehicleNumber);
//		if(obj1.isPresent()) {
//			return Vehicle.toDTO(obj1.get());
//		}
//		else throw new Exception("Invalid Data");
//	}
//	public String updateVehicleStatus(String vehicleNum,VehicleDTO dto) throws Exception {
//		Optional<Vehicle> obj1 = vr.findById(vehicleNum);
//		if(obj1.isPresent()) {
//			Vehicle obj2 = obj1.get();
//			if(!obj2.getVehicleStatus().equalsIgnoreCase(dto.getVehicleStatus())) {
//				if (dto.getVehicleStatus().equalsIgnoreCase("Active") || dto.getVehicleStatus().equalsIgnoreCase("Retired") || dto.getVehicleStatus().equalsIgnoreCase("Inprogress") ) {
//					obj2.setVehicleStatus(dto.getVehicleStatus());
//					return "Vehicle Status successfully changed to :"+dto.getVehicleStatus();
//				}
//				else throw new Exception("Invalid-data");
//			}
//			else {
//				throw new VEHICLE_UPDATE_ALREADY_EXISTS();
//			}
//			
//		}
//		else throw new VEHICLE_NOT_FOUND_EXCEPTION();
//	}
//	public String removeVehicle(String vehicleNumber) throws Exception{
//		Optional<Vehicle> obj1 = vr.findById(vehicleNumber);
//		if(obj1.isPresent()) {
//			vr.delete(obj1.get());
//			return "Vehicle removed successfully";
//		}
//		else throw new Exception("Invalid Data");
//	}
	
	
	

}
