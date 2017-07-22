package com.hanbit.springstagram.controller;

import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanbit.springstagram.service.FileService;
import com.hanbit.springstagram.vo.FileVO;

@Controller
public class FileController {
	
	@Autowired
	private FileService fileService;

	@RequestMapping("/file/{photoId}")
	public void getFile(@PathVariable("photoId")
			String photoId, HttpServletResponse response) throws Exception {
		
		FileVO fileInfo = fileService.getFile(photoId);
		
		if (fileInfo == null) {
			response.sendError(404);
			return;
		}
		
		String filePath = fileInfo.getFilePath();
		String fileType = fileInfo.getFileType();
		long fileLength = fileInfo.getFileLength();
		
		response.setContentType(fileType);
		response.setContentLengthLong(fileLength);
		
		try (FileInputStream inputStream = new FileInputStream(filePath)) {
			IOUtils.copyLarge(inputStream, response.getOutputStream());
		}
		
		response.getOutputStream().flush();
	}
	
}












