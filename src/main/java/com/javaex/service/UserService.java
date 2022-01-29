package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public UserVo login (UserVo userVo) {
		System.out.println("service.login 실행");
		
		UserVo authUser = userDao.selectUser(userVo);
		return authUser;
	} // login
	

	public void join (UserVo userVo) {
		System.out.println("service.join 실행"+userVo);
		
		userDao.insertUser(userVo);
	} // join
	
	public void modify (UserVo userVo) {
		System.out.println("service.join 실행"+userVo);
		
		userDao.updateUser(userVo);
	} // join
	
	public UserVo getUser(UserVo userVo) {
		System.out.println("service.getUser 실행"+userVo);
		return userDao.selectUser(userVo);
	} //getUser
	
	public void selectUserId(String id) {
		System.out.println("service.selectUserId 실행"+id);
		userDao.selectUserId(id);
	}
	
	
	
} // The end of UserService
