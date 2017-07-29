package com.hanbit.springstagram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.springstagram.dao.CommentDAO;
import com.hanbit.springstagram.vo.CommentVO;

@Service
public class CommentService {

	@Autowired
	private IdGenerationService idGenerationService;
	
	@Autowired
	private CommentDAO commentDAO;
	
	public void write(CommentVO comment) {
		comment.setId(idGenerationService.generateId(8));
		
		commentDAO.insertComment(comment);
	}

	public List<CommentVO> list(String photoId) {
		return commentDAO.selectComments(photoId);
	}
	
}







