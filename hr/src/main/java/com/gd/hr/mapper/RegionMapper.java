package com.gd.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Region;

@Mapper		// @Mapper => @Repository public class ..... implements RegionMapper{...} 만들어짐
public interface RegionMapper {
	List<Region> selectRegionList();
	int insertRegion(Region region);
	int updateRegion(Region regionId);		// 수정 action
	Region selectRegionOne(int regionId);	// 상세보기, 수정 form
	
	int deleteRegion(int regionId);
	
}
