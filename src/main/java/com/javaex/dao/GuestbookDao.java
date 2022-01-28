package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestbookVo> getGuestbookList() {
		System.out.println("GuestbookDao.getList 실행");
		
		List<GuestbookVo> guestbookList = sqlSession.selectList("guestbook.selectList");
		
		return guestbookList;
	} // getGuestbookList 

	
	public int contentInsert(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.contentInsert 실행");	
		int count = sqlSession.insert("guestbook.insert", guestbookVo);
		return count;
	} // contentInsert
	
	public int contentDelete(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.contentDelete 실행");
		int count = sqlSession.delete("guestbook.delete", guestbookVo);
		return count;
	} // contentDelete
	
//	방명록 글 저장(selectKey)
	public int insertSelectKey(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.insertSelectKey 실행");
		
		System.out.println("게북 다오 출력 no없다 "+guestbookVo); 
		sqlSession.insert("guestbook.insertSelectKey", guestbookVo);
		System.out.println("게북 다오 출력 no있다 "+guestbookVo); 
		
		return 3;
	} // insertSelectKey
	
	
	
} // The end of GuestbookDao
