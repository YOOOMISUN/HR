package com.gd.hr.service;

import java.util.List;
import java.util.Map;

import com.gd.hr.vo.Location;

public interface ILocationService {
	List<Map<String,Object>> getLocationList();
	int addLocation(Location location);
	Map<String,Object> addLocationForm();
	int removeLocation(int locationId);
}
