package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GalleryVo> getGalleryList() {
		System.out.println("GalleryDao.getGalleryList ");
		List<GalleryVo> galleryList = sqlSession.selectList("gallery.selectList");
		return galleryList;
	}
	
	public GalleryVo readImage(int bno) {
		System.out.println("GalleryDao.readImage");
		GalleryVo galleryVo = sqlSession.selectOne("gallery.readImage", bno);
		return galleryVo;
	}
	
	public void insertImage(GalleryVo galleryVo) {
		System.out.println("GalleryDao.insertImage");
		sqlSession.insert("gallery.insertImage");
	}
 
	public void deleteImage(GalleryVo galleryVo) {
		System.out.println("GalleryDao.deleteImage");
		sqlSession.delete("gallery.deleteImage");
	}
	
	
} // The End of GalleryDao
