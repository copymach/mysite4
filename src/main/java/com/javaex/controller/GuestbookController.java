package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
//	리스트로 가기
	@RequestMapping(value="/guestbook/addList", method= {RequestMethod.POST, RequestMethod.GET})
	public String addList(Model model) {
		System.out.println("guestbook.addList 실행");
		
//		리스트를 만들자
		List<GuestbookVo> guestbookList = guestbookDao.getGuestbookList();
		
//		model을 이용하여 DS 에 리스트 데이터를 보내자
		model.addAttribute("guestbookList", guestbookList);
		
		return "/guestbook/addList";
	} // addList
	
	
	@RequestMapping(value="/guestbook/write", method= {RequestMethod.POST, RequestMethod.GET})
	public String wrtie(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("guestbook.write 실행");
		
		guestbookDao.contentInsert(guestbookVo);
		
		return "redirect:/guestbook/addList";
	} // write
	
	
	@RequestMapping(value="/guestbook/deleteForm", method= {RequestMethod.POST, RequestMethod.GET})
	public String deleteForm() {
		System.out.println("guestbook.deleteForm 실행");
		return "/guestbook/deleteForm";
	} // deleteForm
	
	
	@RequestMapping(value="/guestbook/delete", method= {RequestMethod.POST, RequestMethod.GET})
	public String delete(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("guestbook.delete 실행");
		
		guestbookDao.contentDelete(guestbookVo);
		
		return "redirect:/guestbook/addList";
	}
	
} // The end of GuestbookController
