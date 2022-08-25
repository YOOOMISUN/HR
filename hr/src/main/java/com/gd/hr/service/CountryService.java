package com.gd.hr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.hr.mapper.CountryMapper;
import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

@Service
@Transactional
public class CountryService implements ICountryService {
	@Autowired RegionMapper regionMapper;
	@Autowired CountryMapper countryMapper;
	
	
	@Override
	public List<Region> addCountryForm() {
		List<Region> regionList = regionMapper.selectRegionList();
		return regionList;
	}
	
	@Override
	public List<Map<String, Object>> selectCountryList() {
		List<Map<String, Object>> list = countryMapper.selectCountryList();
		return list;
	}

	@Override
	public int addCountry(Country country) {
		
		return countryMapper.insertCountry(country);
	}

	@Override
	public int modiryCountry(Country countryId) {
		
		return countryMapper.updateCountry(countryId);
	}

	@Override
	public Country getCountry(String countryId) {
		
		return countryMapper.selectCountryForm(countryId);
	}

	@Override
	public int removeCountry(String countryId) {
		
		return countryMapper.deleteCountry(countryId);
	}

	

}
