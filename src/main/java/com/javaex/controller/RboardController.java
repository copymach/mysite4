package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.RboardService;
import com.javaex.vo.RboardVo;

@Controller
public class RboardController {

	@Autowired
	private RboardService rboardService;
	
//	리스트 출력
	@RequestMapping(value="/rboard/list", method= {RequestMethod.POST, RequestMethod.GET})
	public String list(Model model) {
		System.out.println("rboard.list 출력");
		
		List<RboardVo> rboardList= rboardService.getRboardList();
		
//		DS에서 리스트 데이터 공유하는 model
		model.addAttribute("rboardList",rboardList);
		
		return "rboard/list";
	} // list	
	
} // The end of RboardController
