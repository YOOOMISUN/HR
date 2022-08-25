package com.gd.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gd.hr.service.ILocationService;

@Controller
public class LocationController {
	@Autowired ILocationService locationService;
	
	@GetMapping("/locationList")
	public String selectLocation(Model model) {
		
		
		return null;
		
	}
	
	
}
