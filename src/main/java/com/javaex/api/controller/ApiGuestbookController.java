package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	@ResponseBody //응답의 바디 부분에 붙어서 간다 gVo데이터를 json으로 보낸다  
	@RequestMapping("/write")
	public GuestbookVo write(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("apiGuestbookController.write 실행");
//		System.out.println("guestbookVo 출력 "+guestbookVo);
		
//		저장하고 저장한 값 리턴
		GuestbookVo gVo = guestbookService.addGuestbookResultVo(guestbookVo);
		System.out.println("컨트롤러 gVo 출력 "+gVo);
		return gVo;
	} // write
	
	
	@ResponseBody // json으로 담아라
	@RequestMapping("/remove")
	public String remove(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("apiGuestbookController.remove 실행");
		
		System.out.println("apiGuestbookController.guestbookVo "+guestbookVo);
		
		String result = guestbookService.remove(guestbookVo);
		// result 에서 success fail
		
		System.out.println("api컨트롤러 result 출력 "+result);
		return result;
	} 
	
	@ResponseBody // 리스폰스 바디 응답할때 위치 
	@RequestMapping("/write2") 
	public GuestbookVo write2(@RequestBody GuestbookVo guestbookVo) { 
			// RequestBody 받을때 위치, 어트리뷰트가 아닌 RequestBody쓰면 그곳에서 vo를 찾아 게터세터맞춰줌
			// ,@RequestParam("name") String name) {
		System.out.println("apiGuestbookController.write2 실행");
		
//		System.out.println("apiGuestbookController.name 실행 "+name);
//		name 출력이 안된다 json방식으로 파라미터에 값이 없기 때문
		
		System.out.println("apiGuestbookController.guestbookVo 실행 "+guestbookVo);
		
//		저장하고 저장한 값 리턴
		GuestbookVo gVo = guestbookService.addGuestbookResultVo(guestbookVo);
		System.out.println("컨트롤러 gVo 출력 "+gVo);
		return gVo;
	}
	
	
	
	
	
} // The end of ApiGuestbookController
