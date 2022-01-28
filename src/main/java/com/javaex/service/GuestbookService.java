package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	private GuestbookDao guestbookDao;
	
	public List<GuestbookVo> getGuestbookList() {
		System.out.println("GuestbookService.getGuestbookList 실행");
		return guestbookDao.getGuestbookList();
	}
	
	public void contentInsert(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.contentInsert 실행");
		guestbookDao.contentInsert(guestbookVo);
	}
	
	public void contentDelete (GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.contentDelete 실행");
		guestbookDao.contentDelete(guestbookVo);
	}
	
	public GuestbookVo addGuestbookResultVo(GuestbookVo guestbookVo) {
		System.out.println("GuestbookService.addGuestbookResultVo 실행");
		System.out.println("서비스 guestbookVo 출력 "+guestbookVo);
		
		//저장하기
		int count = guestbookDao.insertSelectKey(guestbookVo);
		
		//저장한 내용 가져오기
		int no = guestbookVo.getNo();
		GuestbookVo gVo = guestbookDao.selectGuest(no);
		return gVo;
	}
	
	
} // The end of  GuestbookService 
