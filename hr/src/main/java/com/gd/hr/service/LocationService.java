package com.gd.hr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.gd.hr.mapper.CountryMapper;
import com.gd.hr.mapper.LocationMapper;
import com.gd.hr.mapper.RegionMapper;

public class LocationService implements ILocationService {
	@Autowired RegionMapper regionMapper;
	@Autowired CountryMapper countryMapper;
	@Autowired LocationMapper locationMapper;
	
	@Override
	public List<Map<String, Object>> getLocationList() {
		List<Map<String,Object>> locationList = locationMapper.selectLocationList();
		return locationList;
	}
	
	
	
}
