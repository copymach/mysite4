package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {

//스프링은 컨트롤러 - 서비스 - 다오 구성
//컨트롤러는 서비스만 사용할것 다오 직접사용x
	
	@Autowired
	private UserService userService;
	
//	로그인폼
	@RequestMapping(value="/user/loginForm", method= {RequestMethod.POST, RequestMethod.GET})
	public String loginForm() {
		System.out.println("UserController.loginForm 로그인폼 ");
		
		return "/user/loginForm";
	} // loginForm 
	
//	로그인
	@RequestMapping(value="/user/login", method= {RequestMethod.POST, RequestMethod.GET})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.login 로그인 ");
		
		UserVo authUser = userService.login(userVo); 
//		.selectUser(userVo);
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
	} // login
	
	
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
	
	
	@RequestMapping(value="/user/joinForm" , method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("user.joinForm 실행");
		return "/user/joinForm";
	} // joinForm
	
//	동일한 id (유니크아이디) 입력하면 에러난다 처리해보자
	@RequestMapping(value="/user/join" , method= {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("user.join 실행");
		
		userService.join(userVo); 
		
		System.out.println("UserController.joinUser 출력 ");
		return "/user/joinOk";
	} // joinOk	
	

	@RequestMapping(value="/user/joinOk" , method= {RequestMethod.GET, RequestMethod.POST})
	public String joinOk() {
		System.out.println("user.joinOk 실행");
		
		return "/user/joinOk";
	} // joinOk
	
	
	@RequestMapping(value="/user/modifyForm" , method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm() {
		System.out.println("user.modifyForm 실행");
		
		return "/user/modifyForm";
	} // modifyForm
	
	
	@RequestMapping(value="/user/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute UserVo userVo, Model model) {
		System.out.println("user.modify 실행");
		
		userService.modify(userVo);
		
//		1명의 정보 서비스를 부르고
		UserVo authUser = userService.getUser(userVo);
		
//		세션에 변경한 값을 넣기
		model.addAttribute("authUser", authUser); 
		
		System.out.println("UC.authUser 출력 "+authUser);
		
		return "redirect:/";
	} // modifyForm	
	
	
} // The end of UserController
