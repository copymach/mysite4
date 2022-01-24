package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
//	로그인폼
	@RequestMapping(value="/user/loginForm", method= {RequestMethod.POST, RequestMethod.GET})
	public String loginForm() {
		System.out.println("UserController.loginForm 로그인폼 ");
		
		return "/user/loginForm";
	} // loginForm 
	
//	http://localhost:8088/mysite4/user/login?id=dd&pw=dd
//	로그인
	@RequestMapping(value="/user/login", method= {RequestMethod.POST, RequestMethod.GET})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.login 로그인 ");
		
		userDao.selectUser(userVo);
		
		UserVo authUser = userDao.selectUser(userVo);
		System.out.println(authUser);
		
		if (authUser != null) {
			System.out.println("로그인 성공");
//			세션에 저장
			session.setAttribute("authUser", authUser);
//			메인으로 리다이렉트
			return "redirect:/";
			
		} else { // 로그인 실패
			System.out.println("로그인 실패");
			return "redirect:/user/loginForm?result=fail";
		}
		
	} // loginForm
	
	
//	로그아웃 세션값 삭제
	@RequestMapping(value="/user/logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("user.logout 실행");
		
//		세션 정보 삭제
		session.removeAttribute("authUser");
//		세션 초기화
		session.invalidate();
		
		System.out.println("logout 성공 세션 비움");
		
		return "redirect:/";
	} // logout
	
	
} // The end of UserController
