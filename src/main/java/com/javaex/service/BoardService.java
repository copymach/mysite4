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
	} // read
	
	public void hit (int bno) {
		System.out.println("BoardService.read 실행");
		boardDao.hit(bno);
	} // hit
	
	public void modify (BoardVo boardVo) {
		System.out.println("BoardService.modify 실행");
		boardDao.modify(boardVo);
	} // modify
	
	public void write (BoardVo boardVo) {
		System.out.println("BoardService.modify 실행");
		/*
		//	페이징 데이터 추가 123개
		for (int i=1; i<=123; i++) {
			boardVo.setTitle(i+"번째 제목입니다");
			boardVo.setContent(i+"번째 내용입니다");
			boardVo.setContent(i+"번째 내용입니다");
			boardVo.setHit(0);
			boardVo.setUno(1);
			}
			*/
		boardDao.write(boardVo);
		
	} // write

	
	
	public void delete (BoardVo boardVo) {
		System.out.println("BoardService.delete 실행");
		boardDao.delete(boardVo);
	} // delete
		
	
} // The end of BoardService 
