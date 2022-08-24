package com.gd.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.hr.service.IRegionService;
import com.gd.hr.vo.Region;

@Controller		// request... 등 사용하게능하게 함
public class RegionController {
	// @RequestMapping(method = GET) => Get 방식, method=POST => Post 방식, @RequestMapping 만 쓰면 두개 다 사용 가능 
	// @GetMapping("") 는 @RequestMapping 축약
	@Autowired IRegionService regionService;	// => new RegionService()
	
	/* 메소드 이름 같은데 파라미터 달라서 오버로딩 */
	
	@GetMapping("/addRegion")		// Form
	public String addRegion() {
		return "addRegion";
	}
	
	
	@PostMapping("/addRegion")		// Action			null이면 1
	public String addRegion(Region region) {		// @RequestParam int regionId = request.getParameter(regionId)
		System.out.println(region);
		
		int row = regionService.addRegion(region);
		System.out.println(row);
		
		return "redirect:/regionList";		// regionList로 redirect 
	}
	
	
	@GetMapping("/regionList") 	// 리턴타입이 String 타입이면 뷰가 됨, MedelAndView
	public String regionList(Model model) {
		List<Region> list = regionService.getRegionList();
		model.addAttribute("list",list);	// model => addAttribute를 쓰려고 씀 request.setAttribute("list",list);
		// System.out.println(list);
		return "regionList";				// ("regionList").forward(request.response);
	}
	
	
	@GetMapping("/removeRegion")			// (@RequestParam(value="regionId", required = false) int regionId)     required = false :  null 값 허용
	public String removeRegion(@RequestParam(value="regionId") int regionId) {	// @RequestParam int regionId = request.getParameter(regionId)
		int row = regionService.removeRegion(regionId);
		System.out.println(row);
		
		return "redirect:/regionList";	
		
	}
	
	@GetMapping("/modifyRegion")		// Form
	public String modifyRegion(Model model,Region region) {
		model.addAttribute("region",region);
		return "modifyRegion";
	}
	
	
	@PostMapping("/modifyRegion")		// Action			null이면 1
	public String modifyRegion(Region region) {		// @RequestParam int regionId = request.getParameter(regionId)
		System.out.println(region);
		
		int row = regionService.modifyRegion(region);
		System.out.println(row);
		
		return "redirect:/regionList";		// regionList로 redirect 
	}
	
}


