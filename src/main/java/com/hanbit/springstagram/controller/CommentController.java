package com.hanbit.springstagram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hanbit.springstagram.service.CommentService;
import com.hanbit.springstagram.vo.CommentVO;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping("/comment")
	public List<CommentVO> write(
			@RequestParam("photoId") String photoId,
			@RequestParam("author") String author,
			@RequestParam("comment") String comment) {
		
		CommentVO commentVO = new CommentVO();
		commentVO.setPhotoId(photoId);
		commentVO.setAuthor(author);
		commentVO.setComment(comment);
		
		commentService.write(commentVO);
		
		return commentService.list(photoId);
	}
	
}












