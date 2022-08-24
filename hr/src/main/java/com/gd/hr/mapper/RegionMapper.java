package com.gd.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Region;

@Mapper		// @Mapper => @Repository public class ..... implements RegionMapper{...} 만들어짐
public interface RegionMapper {
	List<Region> selectRegionList();
	int insertRegion(Region region);
	int updateRegion(Region regionId);
	int deleteRegion(int regionId);
	
}
