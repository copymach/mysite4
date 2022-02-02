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
	
	public RboardVo read (int bno) {
		System.out.println("RboardService.read 실행");
		return rboardDao.read(bno);
	} // read
	
	public void hit (int bno) {
		System.out.println("RboardService.hit 실행");
		rboardDao.hit(bno);
	} // hit
	
	public void write (RboardVo rboardVo) {
		System.out.println("RboardService.write 실행");
		rboardDao.write(rboardVo);
	} // write
	
	public void replyWrite (RboardVo rboardVo) {
		System.out.println("RboardService.replyWrite 실행");
		rboardDao.write(rboardVo);
	} // replyWrite
	
	public void delete (RboardVo rboardVo) {
		System.out.println("RboardService.delete 실행");
		rboardDao.delete(rboardVo);
	} // delete
	
	public void modify (RboardVo rboardVo) {
		System.out.println("RboardService.modify 실행");
		rboardDao.modify(rboardVo);
	} // modify
	
	
} // The end of RboardService 
