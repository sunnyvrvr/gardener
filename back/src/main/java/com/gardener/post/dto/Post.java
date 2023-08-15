package com.gardener.post.dto;


import javax.servlet.http.HttpSession;

import com.gardener.comments.dto.Comments;
import com.gardener.member.dto.Member;
import com.google.gson.JsonElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
		
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Post {
	private int postNum;			//글번호
	private String mainTitle;		//제목
	private String writer;		//작가
	private String content;			//내용
	private String mainTitleImg;	//제목이미지
	private Member member;			//member DTO Post 클래스에 Member 객체를 포함
	
	public Post(int postNum, String mainTitle, String writer, String content, String mainTitleImg) {
		super();
		this.postNum = postNum;
		this.mainTitle = mainTitle;
		this.writer = writer;
		this.content = content;
		this.mainTitleImg = mainTitleImg;

	}

	public String getLoginId() {
        if (this.member != null) {
            return this.member.getLoginId();
        }
        return null; 
    }

    public void setLoginId(String loginId) {
        if (this.member == null) {
            this.member = new Member();
        }
        this.member.setLoginId(loginId);
    }

}

