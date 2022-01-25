package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller // repository를 쓰면 안된다
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
//	리스트 출력
	@RequestMapping(value="/board/list", method= {RequestMethod.POST, RequestMethod.GET})
	public String list(Model model) {
		System.out.println("mysite4.list 실행");
		
		List<BoardVo> boardList = boardService.getBoardList();
		
		System.out.println("model 출력 "+boardList);
		
//		DS에서 리스트 데이터 공유하는 model
		model.addAttribute("boardList",boardList);
		
		return "/board/list";
	} // list
	
	
	@RequestMapping(value="/board/read", method= {RequestMethod.GET, RequestMethod.POST})
	public String read(@RequestParam("bno") int bno, Model model) {
		System.out.println("board.read 실행");
		
//		bno로 받은 게시물 불러오기
		BoardVo boardList = boardService.read(bno);
//		조횟수 1추가
		boardService.hit(bno);
//		가져온 정보를 어트리뷰트에 추가
		model.addAttribute("boardList", boardList);
		
		return "/board/read";
	} // read
	
	@RequestMapping(value="/board/modifyForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam("bno") int bno, Model model) {
		System.out.println("board.modifyForm 실행");
		
		BoardVo boardList = boardService.read(bno);
		
		System.out.println("read 출력 "+boardList);
		boardService.hit(bno); // 조회수 +1
		model.addAttribute("boardList", boardList);
		
		return "/board/read";
	} // modifyForm
	
	
	
	
} // The end of BoardController 
