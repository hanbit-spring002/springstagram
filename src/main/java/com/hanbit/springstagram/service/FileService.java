package com.hanbit.springstagram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.springstagram.dao.FileDAO;

@Service
public class FileService {

	@Autowired
	private FileDAO fileDAO;
	
	public int saveFile() {
		
		return 0;
	}
	
}
