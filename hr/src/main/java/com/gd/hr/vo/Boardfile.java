package com.gd.hr.vo;

import lombok.Data;

@Data
public class Boardfile {
	private int boardfileNo;
	private int boardNo;
	private String filename;
	private String originName;
	private String fileType;
	private long fileSize;
}
