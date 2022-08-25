package com.gd.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Region;

@Service
@Transactional		// 이 클래스 안에 있는 메소드 실행하다가 하나라도 예외가 나오면 옵션 취소 
public class RegionService implements IRegionService {
	// DI : 객체를 직접 생성하지 않고 스프링 프레임워크 통해 (bean 객체 ) 주입
	// Interface 타입을 사용 => 구체적인 클래스 네임을 안나오게 하는것 (디커플링, 느슨하게 하기 위해서)
	@Autowired RegionMapper regionMapper;	 // 인터페이스를 사용해서 주입
	
	@Override
	public List<Region> getRegionList() {

		return regionMapper.selectRegionList();
	}

	@Override
	public int addRegion(Region region) {
		
		return regionMapper.insertRegion(region);
	}

	@Override
	public int removeRegion(int regionId) {
	
		return regionMapper.deleteRegion(regionId);
	}

	@Override
	public int modifyRegion(Region regionId) {
		
		return regionMapper.updateRegion(regionId);
	}

	@Override
	public Region getRegion(int regionId) {

		return regionMapper.selectRegionOne(regionId);
	}

}
