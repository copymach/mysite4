package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.RboardService;

@Controller
public class RboardController {

	@Autowired
	private RboardService rboardService;
	
	@RequestMapping(value="/rboard/list", method= {RequestMethod.POST, RequestMethod.GET})
	public String list(Model model) {
		System.out.println("rboard.list 출력");
		
		return "rboard/list";
	}	
	
} // The end of RboardController
