package com.gd.hr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Location;

@Mapper
public interface LocationMapper {
	List<Map<String,Object>> selectLocationList();
	int insertLocation(Location location);
	int deleteLocation(int locationId);
}
