package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository // 스프링이 dao를 알아먹도록 applicationContext.xml 파일 설정
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// user 정보 가져오기
	public UserVo selectUser(UserVo userVo) {
		System.out.println("UserDao.getUser 실행"+userVo);
		
		UserVo authUser = sqlSession.selectOne("user.selectUser", userVo);
		return authUser;
	}
	
	public void insertUser(UserVo userVo) {
		System.out.println("UserDao.insertUser 실행"+userVo);
		
		sqlSession.insert("user.insertUser", userVo);
	}
	
	public void updateUser(UserVo userVo) {
		System.out.println("UserDao.updateUser 실행"+userVo);
		
		sqlSession.update("user.updateUser", userVo);
	}
	
	public void selectUserId(String id) {
		System.out.println("UserDao.selectUserId 실행"+id);
		
		sqlSession.selectOne("user.selectUserId", id);
	}
	
	
}
