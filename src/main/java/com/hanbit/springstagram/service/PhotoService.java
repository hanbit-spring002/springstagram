package com.hanbit.springstagram.service;

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
	
	@Transactional
	public int write(PhotoVO photo, MultipartFile file) {
		String id = idGenerationService.generateId(8);
		photo.setId(id);
		
		fileService.saveFile(id, file);
		
		return photoDAO.insertPhoto(photo);
	}
	
}
