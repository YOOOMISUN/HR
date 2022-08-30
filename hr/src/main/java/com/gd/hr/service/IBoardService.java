package com.gd.hr.service;

import java.util.List;
import java.util.Map;

import com.gd.hr.vo.BoardForm;

public interface IBoardService {
	List<Map<String, Object>> getBoardList();
	void addBoard (BoardForm boardForm, String path);
	int removeBoard(int boardNo);
}
