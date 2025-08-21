package com.proj.terminal.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proj.terminal.dto.TerminalDTO;
import com.proj.terminal.entity.TerminalEntity;
import com.proj.terminal.exception.EmptyException;
import com.proj.terminal.exception.FailedException;
import com.proj.terminal.exception.NotFoundException;
import com.proj.terminal.service.TerminalService;


@CrossOrigin()
@RestController
@Validated
@RequestMapping("/ftr")
public class TerminalController {
	
	@Autowired
	TerminalService service;
	
	@PostMapping("/terminals")
	public ResponseEntity<String> insertNewTerminal(@RequestBody @Valid TerminalDTO dto ){
		System.out.print("Post call was made");
		String s=service.insertNewTerminal(dto);
		ResponseEntity<String> e=new ResponseEntity<>(s,HttpStatus.ACCEPTED);
		return e;
	}

	@GetMapping("/terminals")
	public ResponseEntity<List<TerminalEntity>> fetchFTRTerminals() throws EmptyException{
		System.out.print("Call made");
		ResponseEntity<List<TerminalEntity>> e=new ResponseEntity<>(service.fetchFTRTerminals(),HttpStatus.ACCEPTED);
		return e;
	}

	@PutMapping("/terminals/{terminalId}/{newCapacity}")
	public ResponseEntity<String> updateTerminal(@PathVariable("terminalId") String terminalId,@PathVariable("newCapacity") @Max(99999) Integer capacity)throws NotFoundException,FailedException{
		String s=service.updateTerminal(terminalId,capacity);
		ResponseEntity<String> e=new ResponseEntity<>(s,HttpStatus.ACCEPTED);
		return e;
	}

	@GetMapping("/terminals/fetchTerminalByItemType/{itemType}")
	public ResponseEntity<List<TerminalEntity>> fetchTerminalByItemType(@PathVariable ("itemType") @Size(min=4,max=30) String itemType) throws NotFoundException{
		ResponseEntity<List<TerminalEntity>> e=new ResponseEntity<>(service.fetchTerminalByItemType(itemType),HttpStatus.ACCEPTED);
		return e;
	}

	@DeleteMapping("/terminals/{terminalId}")
	public ResponseEntity<String> removeTerminal(@PathVariable ("terminalId") String terminalId) throws NotFoundException{
		String s=service.removeTerminal(terminalId);
		ResponseEntity<String> e=new ResponseEntity<>(s,HttpStatus.ACCEPTED);
		return e;
	}

	@GetMapping("/terminals/fetchTerminalByTerminalId/{terminalId}")
	public ResponseEntity<List<TerminalEntity>> fetchTerminalByTerminalId(@PathVariable ("terminalId") String terminalId)throws NotFoundException{
		ResponseEntity<List<TerminalEntity>> e=new ResponseEntity<>(service.fetchTerminalByTerminalId(terminalId),HttpStatus.ACCEPTED);
		return e;
	}	
}
