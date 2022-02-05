package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GalleryController.list ");
		
		List<GalleryVo> galleryList = galleryService.getGalleryList();
		
		model.addAttribute("galleryList", galleryList);
		System.out.println("GC.galleryList 출력 "+galleryList);
		return "/gallery/list";
	}
	
	@RequestMapping("/write")
	public String write(GalleryVo galleryVo) {
		System.out.println("GalleryController.write ");
		galleryService.insertImage(galleryVo);
		return "/gallery/list";
	}
	
	@RequestMapping("/delete")
	public String delete(GalleryVo galleryVo) {
		System.out.println("GalleryController.delete ");
		galleryService.deleteImage(galleryVo);
		return "/gallery/list";
	}
	
	
	
} // The End of GalleryController
