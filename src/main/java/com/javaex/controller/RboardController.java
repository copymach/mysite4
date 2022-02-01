package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.RboardService;
import com.javaex.vo.RboardVo;

@Controller
@RequestMapping("/rboard")
public class RboardController {

	@Autowired
	private RboardService rboardService;
	
//	리스트 출력
	@RequestMapping(value="/list", method= {RequestMethod.POST, RequestMethod.GET})
	public String list(Model model) {
		System.out.println("RboardController.list 출력");
		
		List<RboardVo> rboardList= rboardService.getRboardList();
		
//		DS에서 리스트 데이터 공유하는 model
		model.addAttribute("rboardList",rboardList);
		return "rboard/list";
	} // list	
	
	
	@RequestMapping(value="/read", method= {RequestMethod.GET, RequestMethod.POST})
	public String read(@RequestParam("bno") int bno, Model model) {
		System.out.println("RboardController.read 실행");
		
		RboardVo rboardList = rboardService.read(bno);
		
		rboardService.hit(bno);
		
		model.addAttribute("rboardList", rboardList);
//		System.out.println("UC rboardList 출력"+rboardList);
		return "/rboard/read";
	} // read
	
	
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("RboardController.writeForm 실행");	
		return "/rboard/writeForm";
	} // writeForm
	
	
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute RboardVo rboardVo) {
		System.out.println("RboardController.write 실행");	
		
		rboardService.write(rboardVo);
//		System.out.println("RC rboardVo 출력 "+rboardVo);
		
		return "redirect:/rboard/list";
	} // write
	
	
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute RboardVo rboardVo) {
		System.out.println("RboardController.delete 실행");
		
//		유저번호 uno와 글번호bno가 일치해야 삭제가능
		rboardService.delete(rboardVo);
		return "redirect:/rboard/list";
	} // delete
	
	
	@RequestMapping(value="/modifyForm", method = {RequestMethod.POST, RequestMethod.GET})
	public String modifyForm(@RequestParam("bno") int bno, Model model) {
		System.out.println("RboardController.modifyForm 실행");
		
		RboardVo rboardList = rboardService.read(bno);
		
		model.addAttribute("rboardList", rboardList);
		
//		System.out.println("RC. rboardList 출력 "+rboardList);
		return "/rboard/modifyForm";
	}
	
	@RequestMapping(value="/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute RboardVo rboardVo) {
		System.out.println("RboardController.modify 실행");
		
//		저장한 bno + uno 일치해야 수정기능 동작 
		rboardService.modify(rboardVo);
		System.out.println("RC rboardVo 출력 "+rboardVo);
		
		return "redirect:/rboard/list";
	} // modify
	
	
} // The end of RboardController
