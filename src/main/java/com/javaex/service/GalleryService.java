package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {

	@Autowired
	private GalleryDao galleryDao;
	
	public List<GalleryVo> getGalleryList() {
		System.out.println("GalleryService.getGalleryList ");
		return galleryDao.getGalleryList();
	}
	
	public GalleryVo readImage(int bno) {
		System.out.println("GalleryService.readImage ");
		GalleryVo galleryVo = galleryDao.readImage(bno);
		 return galleryVo;
	}
	
	public void insertImage(GalleryVo galleryVo) {
		System.out.println("GalleryService.insertImage ");
		galleryDao.insertImage(galleryVo);
	}
	
	public void deleteImage(GalleryVo galleryVo) {
		System.out.println("GalleryService.deleteImage ");
		galleryDao.deleteImage(galleryVo);
	}
	
} // The End of GalleryService
