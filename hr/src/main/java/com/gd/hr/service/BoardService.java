package com.gd.hr.service;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gd.hr.mapper.BoardMapper;
import com.gd.hr.mapper.BoardfileMapper;
import com.gd.hr.vo.BoardForm;
import com.gd.hr.vo.Boardfile;

@Service
@Transactional
public class BoardService implements IBoardService {
	@Autowired BoardMapper boardMapper;
	@Autowired BoardfileMapper boardfileMapper;
	
	@Override
	public void addBoard(BoardForm boardForm, String path) {
		System.out.println(boardForm.getBoard().getBoardNo());		// board.getBoardNo() -> 0
		int row = boardMapper.insertBoard(boardForm.getBoard());	// board.getBoardNo() -> selectKey
		System.out.println(boardForm.getBoard().getBoardNo());	
		
		// boardfile insert
		if(row==1 && boardForm.getMultiList() != null) {
			for(MultipartFile mf : boardForm.getMultiList()) {
				Boardfile boardfile = new Boardfile();
				boardfile.setBoardNo(boardForm.getBoard().getBoardNo());
				System.out.println("boardfile.boardNo >> " +  boardfile.getBoardNo());
				
				// 중복되지 않는 랜덤이름 새성 UUID API사용
				String filename = UUID.randomUUID().toString().replace("-", "");
				// 1. 업로드된 파일명의 중복을 방지하기 위해 파일명을 변경할 때 사용.
				// 2. 첨부파일 파일다운로드시 다른 파일을 예측하여 다운로드하는것을 방지하는데 사용.
				// 3. 일련번호 대신 유추하기 힘든 식별자를 사용하여 다른 컨텐츠의 임의 접근을 방지하는데 사용.
				
				// boardfile 입력
				boardfile.setFilename(filename);
				boardfile.setOriginName(mf.getOriginalFilename());
				boardfile.setFileType(mf.getContentType());
				boardfile.setFileSize(mf.getSize());
				boardfileMapper.insertBoardFile(boardfile);
				
				System.out.println("filename >> " + filename);
				System.out.println("OriginalFilename >> " + mf.getOriginalFilename());
				System.out.println("ContentType >> " + mf.getContentType());
				System.out.println("Size >> " + mf.getSize());
				
				// 파일 생성			(MultipartFile에 파일 생성도 들어가 있음)
				String ext = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf("."));	
				System.out.println("파일 확장자 >> " + ext);	// 새로운 빈 파일안에 MultipartFile 안 파일을 하나씩 복사
				// 파일 확장자	: OriginName에서 자름			=> . 위치부터 자름
				try {
					mf.transferTo(new File(path + filename + ext));		// path 안에 파일 생성  c:/upload/ttt.txt
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException();	// 트랜잭션 처리가 되도록 강제로 Runtime 예외(try 절을 강요하지 않는)발생
				}
					
			}
		}

	}

	@Override
	public List<Map<String, Object>> getBoardList() {
		List<Map<String, Object>> boardList = boardMapper.selectBoardList();
		return boardList;
	}
	
	
}
