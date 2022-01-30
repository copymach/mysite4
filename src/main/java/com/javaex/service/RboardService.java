package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.dao.RboardDao;
import com.javaex.vo.BoardVo;
import com.javaex.vo.RboardVo;

@Repository
public class RboardService {

	@Autowired
	private RboardDao rboardDao;
	
	public List<RboardVo> getRboardList () {
		System.out.println("BoardService.getBoardList 실행");
		return rboardDao.getRboardList();
	} // getBoardList
	
	public BoardVo read (int bno) {
		System.out.println("BoardService.read 실행");
		return rboardDao.read(bno);
	} // read
	
	public void hit (int bno) {
		System.out.println("BoardService.hit 실행");
		rboardDao.hit(bno);
	} // hit
	
	
} // The end of RboardService 
