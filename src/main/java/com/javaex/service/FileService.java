package com.javaex.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	
	public void restore(MultipartFile file) {
		System.out.println("FileService.restore ");
		
		System.out.println("FileService.원본파일이름 "+file.getOriginalFilename());
		
//		파일을 하드 디스크에 저장 (운영내용)
		
//		원본파일 이름 (원본파일 이름 그대로 저장하면 중복파일 문제 생겨서 바꿔야함)
		String orgName = file.getOriginalFilename();
		
//		원본파일 이름 확장자 lastIndexOf (엑셀파일 등등)
//		substring파일 이름에서 .의 위치 이후 정해진 위치 이후의 값을 리턴 .jpg 경우 3 리턴 		
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName; // uuid는 스태틱으로 있는듯, 파일이름에 타임커런트밀로 해시 값처럼 저장 
		System.out.println("FS.saveName "+saveName);
		
//		파일을 DB에 저장
		
		
	} // restore
	
	
} // The End of FileService

