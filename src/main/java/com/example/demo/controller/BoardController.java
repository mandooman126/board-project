package com.example.demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.BoardPost;
import com.example.demo.service.BoardService;

@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
	
	@GetMapping("/board")
	public String board(Model model) throws IOException, SQLException {
		List<BoardPost> list = new ArrayList<BoardPost>();
		list = boardService.getPostList();
		
		//jsp 호출
		model.addAttribute("postList" , list);
		return "boardList";
	}
	
}
