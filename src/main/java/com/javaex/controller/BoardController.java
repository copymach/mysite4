package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Controller // repository를 쓰면 안된다
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
//	리스트 출력
	@RequestMapping(value="/board/list", method= {RequestMethod.POST, RequestMethod.GET})
	public String list(Model model) {
		System.out.println("mysite4.list 실행");
		
		List<BoardVo> boardList = boardDao.getBoardList();
		
//		DS에서 리스트 데이터 공유하는 model
		model.addAttribute("boardList",boardList);
		
		return "/board/list";
	} // list
	
	
} // The end of BoardController 
