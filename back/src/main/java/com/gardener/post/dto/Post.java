package com.gardener.post.dto;

<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Post {
	private int postNum;			//글번호
	private int userNum;			//유저아이디(번호)
	private String mainTitle;		//제목
	private String subTitle;		//소제목
	private String content;			//내용
	private String mainTitleImg;	//제목이미지
	private String contentImg;		//내용이미지
	private String category; 		//카테고리
	private int postPublic;			//비공개,공개(0,1)
	private int favorite;			//좋아요
	
	public Post() {
		
	}

	@Override
	public String toString() {
		return "Post [postNum=" + postNum + ", userNum=" + userNum + ", mainTitle=" + mainTitle + ", subTitle="
				+ subTitle + ", content=" + content + ", mainTitleImg=" + mainTitleImg + ", contentImg=" + contentImg
				+ ", category=" + category + ", postPublic=" + postPublic + ", favorite=" + favorite + "]";
	}

	
	
	
=======
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
>>>>>>> origin
}
