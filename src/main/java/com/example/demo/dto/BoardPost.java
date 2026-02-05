package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardPost {
	
	private int id;
	private String title;
	private String writer;
	private String content;
	private LocalDateTime createdAt;
	private int viewCount;
	
}
