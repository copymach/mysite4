package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	public RboardVo read(int bno) {
		System.out.println("RboardDao.read 실행");
		return sqlSession.selectOne("rboard.selectOne", bno);
	} //read
	
	public void hit(int bno) {
		System.out.println("RboardDao.read 실행");
		sqlSession.update("rboard.updateHit", bno);
	} // hit
	
	public void write(RboardVo rboardVo) {
		System.out.println("RboardDao.write 실행");
		sqlSession.insert("rboard.insertContent", rboardVo);
	} // write
	
	public void replyWrite(RboardVo rboardVo) {
		System.out.println("RboardDao.replyWrite 실행");
		sqlSession.insert("rboard.insertReplyContent", rboardVo);
	} // replyWrite
	
	public void delete(RboardVo rboardVo) {
		System.out.println("RboardDao.delete 실행");
		sqlSession.delete("rboard.deleteContent", rboardVo);
	} // delete
	
	public void modify(RboardVo rboardVo) {
		System.out.println("RboardDao.modify 실행");
		sqlSession.update("rboard.modifyContent", rboardVo);
	} // modify

	
} // The end of RboardDao 
