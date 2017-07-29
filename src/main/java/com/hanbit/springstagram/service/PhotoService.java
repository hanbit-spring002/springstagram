package com.hanbit.springstagram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.hanbit.springstagram.dao.PhotoDAO;
import com.hanbit.springstagram.vo.PhotoVO;

@Service
public class PhotoService {

	@Autowired
	private IdGenerationService idGenerationService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private PhotoDAO photoDAO;
	
	public List<PhotoVO> list() {
		return photoDAO.selectPhotos();
	}
	
	@Transactional
	public int write(PhotoVO photo, MultipartFile file) {
		String id = idGenerationService.generateId(8);
		photo.setId(id);
		
		int inserted = photoDAO.insertPhoto(photo);
		
		fileService.saveFile(id, file);
	
		return inserted;
	}
	
	public void like(String id) {
		photoDAO.updateLike(id);
	}
	
	public PhotoVO get(String id) {
		return photoDAO.selectPhoto(id);
	}
	
}
