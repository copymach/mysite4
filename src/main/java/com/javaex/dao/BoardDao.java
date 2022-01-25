package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;


@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVo> getBoardList() {
		System.out.println("BoardDao.getBoardList 실행");
		
		List<BoardVo> boardList = sqlSession.selectList("board.selectList");
		
		return boardList;
	} // getBoardList
	
	public BoardVo read (int bno) {
		System.out.println("BoardDao.read 실행");
		return sqlSession.selectOne("board.selectOne", bno);
	} // read
	
	public void hit (int bno) {
		System.out.println("BoardDao.hit 실행");
		sqlSession.update("board.updateHit", bno);
	} // hit
	
	public void modify (BoardVo boardVo) {
		System.out.println("BoardDao.modify 실행");
		sqlSession.update("board.updateContent", boardVo);
	} // modify
	
	public void write (BoardVo boardVo) {
		System.out.println("BoardDao.modify 실행");
		sqlSession.insert("board.insertContent", boardVo);
	} // write
	
	public void delete (BoardVo boardVo) {
		System.out.println("BoardDao.delete 실행");
		sqlSession.delete("board.deleteContent", boardVo);
	} // delete
	
	
	
	
} // The end of BoardDao
