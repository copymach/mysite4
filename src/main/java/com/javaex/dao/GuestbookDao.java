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
		
		List<GuestbookVo> GuestbookList = sqlSession.selectList("guestbook.selectList");
		
		return GuestbookList;
	} // getGuestbookList 

	
	public int contentInsert(GuestbookVo guestbookVo) {
		int count = sqlSession.insert("guestbook.insert", guestbookVo);
		return count;
	} // contentInsert
	
	public int contentDelete(GuestbookVo guestbookVo) {
		int count = sqlSession.delete("guestbook.delete", guestbookVo);
		return count;
	}
	
	
} // The end of GuestbookDao
