package com.gd.hr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Board;

@Mapper
public interface BoardMapper {
	List<Map<String,Object>> selectBoardList();
	int insertBoard(Board board);
}
