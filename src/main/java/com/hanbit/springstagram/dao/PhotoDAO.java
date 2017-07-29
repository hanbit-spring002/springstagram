package com.hanbit.springstagram.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.springstagram.vo.PhotoVO;

@Repository
public class PhotoDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<PhotoVO> selectPhotos() {
		return sqlSession.selectList("photo.selectPhotos");
	}
	
	public int insertPhoto(PhotoVO photo) {
		return sqlSession.insert("photo.insertPhoto", photo);
	}
	
}
