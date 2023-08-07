package com.gardener.post.dto;

<<<<<<< HEAD
import java.util.Date;

import com.gardener.content.dto.Content;
import com.gardener.member.dto.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
		
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Post {
	private int postNum;			//글번호
	private int userNum;			//회원.아이디(번호)시퀀스
	private String mainTitle;		//제목
	private String subTitle;		//소제목
	private String content;			//내용
	private String mainTitleImg;	//제목이미지
	private String category; 		//카테고리
	private int postPublic;			//비공개,공개(0,1)
	private int favorite;			//좋아요
	private String createPost;		//글 생성일자
	private Content contentTable;	//댓글 dto
	private Member member;			//member DTO
	
}
=======
import javax.swing.text.AbstractDocument.Content;

<<<<<<< HEAD
	@Override
	public String toString() {
		return "Post [postNum=" + postNum + ", userNum=" + userNum + ", mainTitle=" + mainTitle + ", subTitle="
				+ subTitle + ", content=" + content + ", mainTitleImg=" + mainTitleImg + ", contentImg=" + contentImg
				+ ", category=" + category + ", postPublic=" + postPublic + ", favorite=" + favorite + "]";
	}
}
=======
import com.gardener.member.dto.Member;
>>>>>>> 21611a7624e77cf682f16ae501571903703724c6

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;
import java.util.ArrayList;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString

public class Post {
        private int postNum;            //글번호
        private int userNum;            //회원.아이디(번호)시퀀스
        private String mainTitle;        //제목
        private String subTitle;        //소제목
        private String content;            //내용
        private String mainTitleImg;    //제목이미지
        private String category;         //카테고리
        private int postPublic;            //비공개,공개(0,1)
        private int favorite;            //좋아요
        private String createPost;        //글 생성일자
        private Content contentTable;    //댓글 dto
        private Member member;            //member DTO
}

>>>>>>> a25342519161b0a8045e00291ab54d5f2e03857f
