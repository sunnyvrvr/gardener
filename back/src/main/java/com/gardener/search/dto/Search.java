package com.gardener.search.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Search {
	private String mainTitle;		//제목
	private String mainTitleImg;	//제목 이미지
	private String content;			//내용
	private String writer;   		//필명	필드name
	
}
