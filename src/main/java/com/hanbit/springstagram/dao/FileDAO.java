package com.hanbit.springstagram.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.springstagram.vo.FileVO;

@Repository
public class FileDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public int insertFile(FileVO file) {
		return sqlSession.insert("file.insertFile", file);
	}
	
	public FileVO selectFile(String photoId) {
		return sqlSession.selectOne("file.selectFile", photoId);
	}
	
}
