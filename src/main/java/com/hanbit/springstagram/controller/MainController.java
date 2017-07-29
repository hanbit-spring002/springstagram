package com.hanbit.springstagram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanbit.springstagram.service.PhotoService;
import com.hanbit.springstagram.vo.PhotoVO;


@Controller
public class MainController {
	
	@Autowired
	private PhotoService photoService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/write")
	public String write() {
		return "write";
	}
	
	@RequestMapping("/{id}")
	public String detail(@PathVariable("id") String id,
			Model model) {
		PhotoVO photo = photoService.get(id);
		model.addAttribute("photo", photo);
		
		return "detail";
	}
	
}











