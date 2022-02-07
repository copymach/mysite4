package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	// 글 리스트 가져오기 (리스트+페이징)
	public List<BoardVo> getBoardList2(int startRnum, int endRnum) {
		System.out.println("BoardDao.getBoardList2 실행");
//		System.out.println("startRnum endRnum 출력 "+startRnum+", "+endRnum);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRnum", startRnum);
		map.put("endRnum", endRnum);
		
		List<BoardVo> boardList = sqlSession.selectList("board.selectList2", map);
//		System.out.println("boardList 페이징 갯수 출력"+boardList);
		
		return boardList;
	} // getBoardList
	
//	전체 글 갯수 가져오기
	public int selectTotal() {
		System.out.println("BoardDao.selectTotal 실행");
		return sqlSession.selectOne("board.totalCnt"); 
	}
	
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
