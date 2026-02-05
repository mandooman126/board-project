package com.example.demo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.BoardPost;

@Repository
public class BoardDao {

	public List<BoardPost> selectAllPosts() throws IOException, SQLException {
		List<BoardPost> list = new ArrayList<BoardPost>();
		Connection conn = DriverManager.getConnection(
			    "jdbc:mysql://localhost:3306/boarddb",
			    "sa",
			    ""
			);
		
		String sql = "SELECT * BOARD";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			BoardPost post = new BoardPost();
			
			post.setId(rs.getInt("id"));
			post.setTitle(rs.getString("title"));
			post.setWriter(rs.getString("writer"));
			post.setContent(rs.getString("content"));
			post.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
			post.setViewCount(rs.getInt("viewCount"));
			
			list.add(post);
		}
		
		return list; 
	}
	
}
