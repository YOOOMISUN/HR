package com.gd.hr.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gd.hr.service.ICountryService;
import com.gd.hr.vo.Country;

@RestController // RestController안의 메서드이 리턴값을 JSON으로 변경후 응답
public class CountryRestController {
   
   @Autowired ICountryService countryService;
   
   @GetMapping("/rest/getCountryList")
   public List<Country> restGetCountryList(@RequestParam(value="regionId") int regionId) {
      System.out.println("CountryRestController "+regionId);
      List<Country> list = countryService.getCountryIdAndNameList(regionId);   
      return list;
   }
}
