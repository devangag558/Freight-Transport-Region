package com.proj.terminal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import com.proj.terminal.dto.TerminalDTO;
import com.proj.terminal.entity.TerminalEntity;
import com.proj.terminal.exception.EmptyException;
import com.proj.terminal.exception.FailedException;
import com.proj.terminal.exception.NotFoundException;
import com.proj.terminal.repository.TerminalRepository;




@Service
public class TerminalService {
	

private TerminalRepository terminalrepo;
	
	@Autowired
	public void setSimRepo(TerminalRepository terminalrepo) {
		this.terminalrepo=terminalrepo;
	}
	
	//----------------------------------------------------------------------------------------
	
	//INSERT NEW TERMINAL
	
	public String insertNewTerminal(TerminalDTO dto) {
		terminalrepo.saveAndFlush(TerminalDTO.prepareTerminalEntity(dto));
		return "Added successfully";
		
	}
	
	//Fetching
	
	public List<TerminalEntity> fetchFTRTerminals() throws EmptyException{
		List<TerminalEntity> l=terminalrepo.findAll();
		if (l.isEmpty()) {
			throw new EmptyException(" No terminals exists, please add.");
		}
		else {
			return l;
		}
	}
	
	//Updating Capacity
	
	public String updateTerminal(String terminalId,Integer capacity) throws NotFoundException,FailedException{
		Optional<TerminalEntity> pro=terminalrepo.findById(terminalId);
		if (pro.isPresent()) {
			TerminalEntity t=pro.get();
			if(t.getAvailablecapacity()<capacity) {
				throw new FailedException("Available capacity is less than new Capacity");
			}
			else if(t.getAvailablecapacity()==capacity) {
				t.setCapacity(t.getCapacity()+capacity);
				t.setStatus("NotAvailable");
				t.setAvailablecapacity(0);
			}
			else {
				t.setCapacity(t.getCapacity()+capacity);
				t.setAvailablecapacity(t.getAvailablecapacity()-capacity);
			}
			terminalrepo.save(t);
			return "Terminal Capacity successfully changed for ID :"+terminalId; 
		}
		else {
			throw new NotFoundException("Terminal details not found for ID :"+terminalId);
		}
	}
	
	//GET BY ITEMTYPE
	
	public List<TerminalEntity> fetchTerminalByItemType(String itemType) throws NotFoundException{
		
		List<TerminalEntity> pro=terminalrepo.findByItem(itemType);
		System.out.print(pro);
		if (pro.isEmpty()) {
			throw new NotFoundException("No such Item type exists");
			
		}
		else {
			return pro;
		}
	}
	
	//DELETING 
	
	public String removeTerminal(String terminalId) throws NotFoundException {
		Optional<TerminalEntity> pro=terminalrepo.findById(terminalId);
		if (pro.isPresent()) {
			terminalrepo.deleteById(terminalId);
			return "Terminal details are deleted successfully";
		}
		else {
			throw new NotFoundException("Terminal details not found for ID :"+terminalId);
		}
	}
	
	//Get by TerminalId
	public List<TerminalEntity> fetchTerminalByTerminalId(String terminalId)throws NotFoundException{
		List<TerminalEntity> pro=terminalrepo.findByTId(terminalId);
		if (pro.isEmpty()) {
			throw new NotFoundException("Terminal details not found for ID :"+terminalId);
			
		}
		else {
			return pro;
		}
	}
}
