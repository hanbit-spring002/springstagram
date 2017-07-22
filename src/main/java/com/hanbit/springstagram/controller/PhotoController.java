package com.hanbit.springstagram.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PhotoController {

	@RequestMapping("/write")
	public Map write() {
		
		return null;
	}
	
}
