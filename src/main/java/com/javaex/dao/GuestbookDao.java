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
	
//	방명록 글 저장(selectKey) // 성공한 갯수 리턴
	public int insertSelectKey(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.insertSelectKey 실행");
		
//		sqlSession.selectOne("guestbook.selectGuest", guestbookVo.getNo());
		return sqlSession.insert("guestbook.insertSelectKey", guestbookVo);
	} // insertSelectKey
	
	
	//방명록 글1개 가져오기
   public GuestbookVo selectGuest(int no) {
      System.out.println("guestbookDao/selectGuest");
      return sqlSession.selectOne("guestbook.selectByNo", no);
   } // selectGuest

   
} // The end of GuestbookDao

