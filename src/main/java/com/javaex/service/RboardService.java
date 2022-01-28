package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.dao.RboardDao;
import com.javaex.vo.RboardVo;

@Repository
public class RboardService {

	@Autowired
	private RboardDao rboardDao;
	
	public List<RboardVo> getRboardList () {
		System.out.println("BoardService.getBoardList 실행");
		return rboardDao.getRboardList();
	} // getBoardList
	
	
} // The end of RboardService 
