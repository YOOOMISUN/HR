package com.gd.hr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.hr.mapper.CountryMapper;
import com.gd.hr.mapper.LocationMapper;
import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Location;
import com.gd.hr.vo.Region;

@Service
@Transactional
public class LocationService implements ILocationService {
	@Autowired RegionMapper regionMapper;
	@Autowired CountryMapper countryMapper;
	@Autowired LocationMapper locationMapper;
	
	@Override
	public List<Map<String, Object>> getLocationList() {
		List<Map<String,Object>> locationList = locationMapper.selectLocationList();
		return locationList;
	}

	@Override
	public int addLocation(Location location) {
		System.out.println(location);
		int row = locationMapper.insertLocation(location);
		return row;
	}

	@Override
	public Map<String, Object> addLocationForm() { 
		Map<String, Object> resultMap = new HashMap<>();
		List<Region> regionList = regionMapper.selectRegionList();
		resultMap.put("regionList", regionList);
		return resultMap;
	}

	@Override
	public int removeLocation(int locationId) {
		int re = locationMapper.deleteLocation(locationId);
		return re;
	}
	
	
	
}
