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
	
	@GetMapping("/regionList") 	// 리턴타입이 String 타입이면 뷰가 됨, MedelAndView
	public String regionList(Model model) {
		List<Region> list = regionService.getRegionList();
		model.addAttribute("list",list);	// model => addAttribute를 쓰려고 씀 request.setAttribute("list",list);
		// System.out.println(list);
		return "regionList";				// ("regionList").forward(request.response);
	}
	
	// 추가 Form
	@GetMapping("/addRegion")		
	public String addRegion() {
		return "addRegion";
	}
	
	// 추가 Action
	@PostMapping("/addRegion")					
	public String addRegion(Region region) {		// @RequestParam int regionId = request.getParameter(regionId)
		System.out.println(region);
		
		int row = regionService.addRegion(region);
		System.out.println(row);
		
		return "redirect:/regionList";		// regionList로 redirect 
	}
	
	// 수정 Form
	@GetMapping("/modifyRegion")		
	public String modifyRegion(Model model, @RequestParam(value="regionId") int regionId) {	// 하나의 객체일 경우 : (@RequestParam(value="regionId") int regionId) 사용
								// @RequestParam(value="regionId") : value 값은 modifyRegion id의 name 값과 같음 / request.getParameter(regionId)로 불러오기
		Region region = regionService.getRegion(regionId);
		model.addAttribute("region",region);
		return "modifyRegion";			// 포워딩
	}
	
	// 수정 Action
	@PostMapping("/modifyRegion")					
	public String modifyRegion(Region region) {		// @RequestParam int regionId = request.getParameter(regionId)
		
		int row = regionService.modifyRegion(region);
		System.out.println(row);
		
		return "redirect:/regionList";		// regionList로 redirect 
	}
	
	@GetMapping("/removeRegion")			// (@RequestParam(value="regionId", required = false) int regionId)     required = false :  null 값 허용
	public String removeRegion(@RequestParam(value="regionId") int regionId) {	// @RequestParam int regionId = request.getParameter(regionId)
		int row = regionService.removeRegion(regionId);
		System.out.println(row);
		
		return "redirect:/regionList";	
	}
	
	
}


