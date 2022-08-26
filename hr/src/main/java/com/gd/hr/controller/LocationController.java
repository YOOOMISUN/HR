package com.gd.hr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.hr.service.ICountryService;
import com.gd.hr.service.ILocationService;
import com.gd.hr.vo.Country;
import com.gd.hr.vo.Location;
import com.gd.hr.vo.Region;

@Controller
public class LocationController {
	@Autowired ILocationService locationService;
	@Autowired ICountryService countryService;
	
	
	@GetMapping("/locationList")
	public String selectLocation(Model model) {
		List<Map<String,Object>> locationList = locationService.getLocationList();
		model.addAttribute("locationList",locationList);
		return "locationList";
	}
	
	@GetMapping("/addLocation")
	public String addLocation(Model model, Country country,Location location) {
		List<Region> regionList =  countryService.addCountryForm();
		model.addAttribute("regionList", regionList);
		return "addLocation"; 	// <select><c:foreach var="region" items="${regionList}"><option>....
	}

	
	@PostMapping("/addLocation")	// addAction
	public String addLocation(Location location) {
		System.out.println(location.toString());
		int row = locationService.addLocation(location);
		System.out.println(row);
		return "redirect:/locationList";
	}
	
}
