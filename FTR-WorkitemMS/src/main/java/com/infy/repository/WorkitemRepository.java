package com.infy.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Workitem;

public interface WorkitemRepository extends JpaRepository<Workitem, String> {
	public Optional<List<Workitem>> findByUserId(Long userId);

}
