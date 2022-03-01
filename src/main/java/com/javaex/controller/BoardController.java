package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Controller // repository를 쓰면 안된다
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
//	리스트 출력 list
	@RequestMapping(value="/board/list", method= {RequestMethod.POST, RequestMethod.GET})
	public String list(Model model) {
		System.out.println("mysite4.list 실행");
		
		List<BoardVo> boardList = boardService.getBoardList();
		
//		DS에서 리스트 데이터 공유하는 model
		model.addAttribute("boardList",boardList);
		
		return "/board/list";
	} // list

//	리스트 출력 + 페이징
	@RequestMapping(value="/board/list2", method= {RequestMethod.POST, RequestMethod.GET})
	public String list2(Model model, 
			@RequestParam(value="crtPage", required=false, defaultValue="1") int crtPage) { // crtPage 암것도 없을때 1페이지
		System.out.println("mysite4.list2 실행 crtPage "+crtPage);
		
//		해당 페이지의 글 리스트 10개
		Map<String, Object> pMap = boardService.getBoardList2(crtPage);
		
		System.out.println("BC.pMap 출력 "+pMap);
		
//		DS에서 리스트 데이터 공유하는 model
//		model.addAttribute("boardList",boardList);
		
		model.addAttribute("pMap", pMap);
		
		return "/board/list";
	} // list2
	
	
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
//		bno로 받은 게시물 불러오기
		BoardVo boardList = boardService.read(bno);
//		가져온 정보를 어트리뷰트에 추가
		model.addAttribute("boardList", boardList);
		return "/board/modifyForm";
	} // modifyForm
	
	

	@RequestMapping(value="/board/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println("board.modify 실행");
		
		boardService.modify(boardVo);
		
		return "redirect:/board/list";
	} // modify
	
	
	@RequestMapping(value="/board/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("board.writeForm 실행");
		
		return "/board/writeForm";
	} // writeForm
	
	
	@RequestMapping(value="/board/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute BoardVo boardVo) {
		System.out.println("board.write 실행");
		
//		1명의 정보 서비스를 부르고
//		UserVo authUser = boardService.getUser(userVo);
//		세션에 변경한 값을 넣기
//		model.addAttribute("authUser", authUser); 
		
		boardService.write(boardVo);
		System.out.println("BC.boardVo 확인 "+boardVo);
		return "redirect:/board/list";
	} // writeForm
	
	@RequestMapping(value="/board/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute BoardVo boardVo) {
		System.out.println("board.delete 실행");
		
//		유저번호uno 글번호bno 가 일치해야 삭제가능-불일치 삭제안하고 리스트로 복귀
		boardService.delete(boardVo);
		
		return "redirect:/board/list";
	} // delete	
	
	
	
} // The end of BoardController 
