package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	
	@RequestMapping(value="/", method={RequestMethod.GET, RequestMethod.POST })
	public String main() {
		System.out.println("MainController.main 메인 페이지");
		
		return "main/index";
	} // main main main 
	
	
} // The End of MainController 
