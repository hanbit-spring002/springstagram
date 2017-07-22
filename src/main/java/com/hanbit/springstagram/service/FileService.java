package com.hanbit.springstagram.service;

import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hanbit.springstagram.dao.FileDAO;
import com.hanbit.springstagram.vo.FileVO;

@Service
public class FileService {
	
	private static final String FILE_BASE_PATH = "/hanbit/files/";

	@Autowired
	private FileDAO fileDAO;
	
	public int saveFile(String photoId, MultipartFile file) {
		
		String filePath = FILE_BASE_PATH + "photos/" + photoId;
		
		try (FileOutputStream outputStream
				= new FileOutputStream(filePath)) {
			IOUtils.copyLarge(file.getInputStream(), outputStream);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		FileVO fileInfo = new FileVO();
		fileInfo.setPhotoId(photoId);
		fileInfo.setFilePath(filePath);
		fileInfo.setFileType(file.getContentType());
		fileInfo.setFileLength(file.getSize());
		
		return fileDAO.insertFile(fileInfo);
	}

	public FileVO getFile(String photoId) {
		return fileDAO.selectFile(photoId);
	}
	
}












