package com.gd.hr.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data

 public class BoardForm{
  	private Board board;		// <input name="board.boardNo"
  	private List<MultipartFile> multiList;
 }

//
//public class BoardForm extends Board{		// 인터페이스 상속
//	private List<MultipartFile> multiList;
//}