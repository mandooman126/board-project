package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping("/board")
	public String board() {
		
		//commit test1 -> 내 로컬 dev 브랜치 -> origin 브랜치로 commit, push
		//commit test2 -> 내 로컬 dev 브랜치 -> origin 브랜치로 commit, push 이후 main pull - main push 이후 merge
		return "boardList";
	}
	
}
