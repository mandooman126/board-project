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

	public List<BoardPost> getPostList() throws IOException, SQLException {
		List<BoardPost> list = new ArrayList<BoardPost>();
		BoardDao dao = new BoardDao();
		list = dao.selectAllPosts();
		
		return list;
	}
}
