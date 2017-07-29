package com.hanbit.springstagram.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.springstagram.vo.CommentVO;

@Repository
public class CommentDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public int insertComment(CommentVO comment) {
		return sqlSession.insert("comment.insertComment", comment);
	}

	public List<CommentVO> selectComments(String photoId) {
		return sqlSession.selectList("comment.selectComments", photoId);
	}
	
}
