package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;
import com.javaex.vo.RboardVo;

@Repository
public class RboardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<RboardVo> getRboardList() {
		System.out.println("RboardDao.getRboardList 실행");
		
		List<RboardVo> rboardList = sqlSession.selectList("rboard.selectList");
		return rboardList;
	} // getBoardList

	public BoardVo read(int bno) {
		System.out.println("RboardDao.read 실행");
		return sqlSession.selectOne("rboard.selectOne", bno);
	} //read
	
	public void hit(int bno) {
		System.out.println("RboardDao.read 실행");
		sqlSession.update("rboard.updateHit", bno);
	}
	
} // The end of RboardDao 
