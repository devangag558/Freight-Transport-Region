package com.proj.terminal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proj.terminal.entity.TerminalEntity;



public interface TerminalRepository extends JpaRepository<TerminalEntity,String>{
	
	public List<TerminalEntity> findAll();
	
	@Query("select e from TerminalEntity e where e.terminalId=?1")
	public List<TerminalEntity> findByTId(String terminalId);
	
	@Query("select e from TerminalEntity e where e.itemType=?1")
	public List<TerminalEntity> findByItem(String itemType);
}
