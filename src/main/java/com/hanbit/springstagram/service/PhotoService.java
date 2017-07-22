package com.hanbit.springstagram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public int write(PhotoVO photo) {
		
		return 0;
	}
	
}
