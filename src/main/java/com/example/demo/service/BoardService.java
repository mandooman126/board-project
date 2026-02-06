package com.example.demo.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDao;
import com.example.demo.dto.BoardPost;

@Service
public class BoardService {

	private final BoardDao boardDao;
	
	public BoardService(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public List<BoardPost> getPostList() throws IOException, SQLException {
		List<BoardPost> list = new ArrayList<BoardPost>();
		list = boardDao.selectAllPosts();
		
		return list;
	}
}
