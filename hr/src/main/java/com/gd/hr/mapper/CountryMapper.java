package com.gd.hr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Country;

@Mapper
public interface CountryMapper {
	List<Map<String, Object>> selectCountryList();
	int insertCountry(Country country);
	int updateCountry(Country country);
	Country selectCountryForm(String countryId);
	int deleteCountry(String countryId);
	int deleteCountryByRegionId(int regionId);
	
	List<Country> selectCountryIdAndNameList(int regionId);		
	
}
