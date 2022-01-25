package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public List<BoardVo> getBoardList () {
		System.out.println("BoardService.getBoardList 실행");
		
		return boardDao.getBoardList();
	} // getBoardList
	
	
	public BoardVo read (int bno) {
		System.out.println("BoardService.read 실행");
		
		return boardDao.read(bno);
	}
	
	public void hit (int bno) {
		System.out.println("BoardService.read 실행");
		boardDao.hit(bno);
	}
	
	
} // The end of BoardService 
