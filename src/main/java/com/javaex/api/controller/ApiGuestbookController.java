package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("/api/guestbook") // 새로운 컨트롤러 추가 spring-servlet.xml
public class ApiGuestbookController {

	@Autowired
	//private GuestbookService guestbookService;
	private GuestbookDao guestbookDao;
	
	@RequestMapping("/addList") // 줄여 쓴 주소 어떻게 쓰는지 확인 
	public String addList() {
		System.out.println("apiGuestbookController.addList 실행");
		
		return "aGuestbook/addList";
	} // addList
	
	@RequestMapping("/list")
	public String list() {
		System.out.println("apiGuestbookController.list 실행");
		
		List<GuestbookVo> guestbookList = guestbookDao.getGuestbookList();
		System.out.println("guestbookList 출력 "+guestbookList);
		return "";
	} // list
	
} // The end of ApiGuestbookController

