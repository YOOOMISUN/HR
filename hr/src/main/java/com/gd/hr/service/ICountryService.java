package com.gd.hr.service;

import java.util.List;
import java.util.Map;

import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

public interface ICountryService {
	List<Map<String,Object>> selectCountryList();
	List<Region> addCountryForm();
	int addCountry(Country country);
	int modiryCountry(Country counryId);
	Country getCountry(String countryId);
	int removeCountry(String countryId);
}
