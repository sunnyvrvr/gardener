package com.gardener.post.dto;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor

public class Post {
	private int postNum;            //글번호
    private int id;            //유저아이디(번호)
    private String mainTitle;        //제목
    private String subTitle;        //소제목
    private String content;            //내용
    private String mainTitleImg;    //제목이미지
    private String contentImg;        //내용이미지
    private String category;         //카테고리
    private int postPublic;            //비공개,공개(0,1)
    private int favorite;            //좋아요
=======
public class Post {
>>>>>>> ca6ce0378bd2e378480644d4496b70b73bf43b04
}
