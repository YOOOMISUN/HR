package com.gd.hr.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Boardfile;

@Mapper
public interface BoardfileMapper {
	int insertBoardFile(Boardfile boardfile);
	int deleteBoardFile(int boardFileNo);
}
