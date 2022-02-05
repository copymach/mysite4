package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.FileService;

@Controller
@RequestMapping("/fileupload")
public class FileController {

	@Autowired
	private FileService fileService;
	
	@RequestMapping("/form")
	public String form() {
		System.out.println("FileController.form ");
		
		return "/fileupload/form";
	} 
	
//	@RequestMapping("/result")
//	public String result() {
//		System.out.println("FileController.result ");
//		return "/fileupload/result";
//	} 
	
	
//	파일 업로드 처리
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, Model model) {
		System.out.println("FileController.upload ");
		
//		System.out.println("FileController.file "+file);
//		파일 이름이 떠도 이름만 출력하는것이라 정상적으로 받은것처럼 착각 할 수 있음  
		
		fileService.restore(file);
//		System.out.println("FileController.file 사이즈 "+file.getSize());
		System.out.println("FileController.file 원본파일이름 "+file.getOriginalFilename());
		
		String saveName = fileService.restore(file);
		model.addAttribute("saveName", saveName);
		
		return "/fileupload/result";
	} 
	
	
	
	
} // The End of FileController

