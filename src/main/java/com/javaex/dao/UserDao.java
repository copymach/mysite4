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
	public UserVo getUser(UserVo userVo) {
		System.out.println("UserDao.getUser 실행"+userVo);
		
		UserVo authUser = sqlSession.selectOne("user.getUser", userVo);
		return authUser;
	}
	
}
