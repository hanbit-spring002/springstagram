package com.hanbit.springstagram.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hanbit.springstagram.service.PhotoService;
import com.hanbit.springstagram.vo.PhotoVO;

@RestController
@RequestMapping("/api")
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;

	@RequestMapping("/write")
	public Map write(MultipartHttpServletRequest request) {
		MultipartFile file = request.getFile("img");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		PhotoVO photo = new PhotoVO();
		photo.setName(name);
		photo.setContent(content);
		
		photoService.write(photo, file);
		
		Map map = new HashMap();
		map.put("result", "success");
		
		return map;
	}
	
}
