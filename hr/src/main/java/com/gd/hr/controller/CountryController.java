package com.gd.hr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.hr.service.ICountryService;
import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

@Controller
public class CountryController {
	@Autowired ICountryService countryService;
	
	@GetMapping("/countryList")
	public String selectCountryList(Model model){
		List<Map<String,Object>> countryList = countryService.selectCountryList();
		model.addAttribute("countryList",countryList);
		return "countryList";
	}
	
	@GetMapping("/addCountry")		// Form
	public String addCountry(Model model) {
		List<Region> regionList = countryService.addCountryForm();
		model.addAttribute("regionList",regionList);
		
		// 디버깅
		System.out.println("regionList : " + regionList);
		
		return "addCountry";		// <select><c:foreach var="region" items="${regionList}"><option>....</select>
	}
	
	
	@PostMapping("/addCountry")		// Action
	public String addCountry(Country country) {
		int insertCountry = countryService.addCountry(country);
		// 디버깅
		System.out.println("insertCountry : " + insertCountry);
		
		return "redirect:/countryList";		
	}
	
	// 수정 Form
	@GetMapping("/modifyCountry")		
	public String modifyCountry(Model model, Country country) {
		List<Region> regionList = countryService.addCountryForm();
		model.addAttribute("regionList",regionList);
		model.addAttribute("country",country);
		return "modifyCountry";			// 포워딩
	}
	
	// 수정 Action
	@PostMapping("/modifyCountry")					
	public String modifyCountry(Country country) {		
		
		int row = countryService.modiryCountry(country);
		System.out.println(row);
		
		return "redirect:/countryList";		// countryList로 redirect 
	}
	
	
	@GetMapping("/removeCountry")
	public String removeCountry(@RequestParam(value="countryId") String countryId) {
		
		int row = countryService.removeCountry(countryId);
		
		// 디버깅
		System.out.println("removeCountry : " + row);
		
		return "redirect:/countryList";
		
	}
	
	
	
	
}
