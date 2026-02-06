package com.example.demo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.BoardPost;

@Repository
public class BoardDao {


    private final DataSource dataSource;

    public BoardDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
	
	public List<BoardPost> selectAllPosts() throws IOException, SQLException {
		List<BoardPost> list = new ArrayList<BoardPost>();
		String sql = "SELECT * FROM BOARD";

		try (
			//try-with-resources 방식
			//try(자원 선언)
//			Connection conn = DriverManager.getConnection(
//			    "jdbc:mysql://localhost:3306/boarddb",
//			    "sa",
//			    ""
//			);
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		
		) { 
			while(rs.next()) {
				BoardPost post = new BoardPost();
				
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setWriter(rs.getString("writer"));
				post.setContent(rs.getString("content"));
				post.setCreatedAt(rs.getTimestamp("CREATED_AT").toLocalDateTime());
				post.setViewCount(rs.getInt("VIEW_COUNT"));
				
				list.add(post);
			}
		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
		return list; 
	}
	
}
