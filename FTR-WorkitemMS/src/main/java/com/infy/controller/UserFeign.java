package com.infy.controller;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="UserMS")
public interface UserFeign {
	
//	@GetMapping("/ftr/username/{userid}")
//	public UserDTO getUser(@PathVariable)
	
}
