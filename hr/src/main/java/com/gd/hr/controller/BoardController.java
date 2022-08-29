package com.gd.hr.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gd.hr.service.IBoardService;
import com.gd.hr.vo.BoardForm;

@Controller
public class BoardController {
	@Autowired IBoardService boardService;
	
	@GetMapping("/boardList")
	public String selectBoardList(Model model) {
		List<Map<String,Object>> list = boardService.getBoardList();
		model.addAttribute("boardList", list);
		return "boardList";
		
	}
	
	
	@GetMapping("/addBoard")
	public String addBoard() {
		return "addBoard";
	}
	
	@PostMapping("/addBoard")		// 서비스 : 서비스에서 입력된 파일을 분석하고 재조합해주는 역할, 서비스에서 분해해서 분석
	public String addBoard(BoardForm boardForm, HttpSession session) {		// HttpServletRequest request ->  세션이 없으면 request에서 갖구옴
		// String path = request.getservletContext().getRealPath("/upload");   // 폴더의 위치 알수 있음, 세션이 없으면 request에서 갖구옴
		String path = session.getServletContext().getRealPath("/upload");		// 세션이 있으면 세션에서 갖구옴, 세션이 없으면 request에서 갖구옴
		// 파일 저장하는 용도 Path
		boardService.addBoard(boardForm,path);
		System.out.println("path : " + path);
		
		return "redirect:/boardList";
		
	}
}
