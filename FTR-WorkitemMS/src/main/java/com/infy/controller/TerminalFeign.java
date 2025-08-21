package com.infy.controller;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="TerminalMS")
public interface TerminalFeign {

}
