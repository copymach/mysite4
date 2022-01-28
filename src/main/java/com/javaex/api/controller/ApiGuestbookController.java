package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("/api/guestbook") // 새로운 컨트롤러 추가 spring-servlet.xml
public class ApiGuestbookController {

	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping("/addList") // 줄여 쓴 주소 어떻게 쓰는지 확인 
	public String addList() {
		System.out.println("apiGuestbookController.addList 실행");
		
		return "aGuestbook/addList";
	} // addList
	
	
	@ResponseBody // js로 응답할때 문자열로 번역해서 보내야하함-리스폰스바디와 리턴을 붙혀 스프링이 자동 해결
	@RequestMapping("/list")
	public List<GuestbookVo> list() {
		System.out.println("apiGuestbookController.list 실행");
		
		List<GuestbookVo> guestbookList = guestbookService.getGuestbookList();
		System.out.println("guestbookList 출력 "+guestbookList);
		
		return guestbookList;
	} // list
	
	
	@RequestMapping("/write")
	public String write(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("apiGuestbookController.write 실행");
//		System.out.println("guestbookVo 출력 "+guestbookVo);
		
//		저장하고 저장한 값 리턴
		guestbookService.addGuestbookResultVo(guestbookVo);

		return "";
	} // write
	
} // The end of ApiGuestbookController
