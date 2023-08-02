package com.gardener.post.dto;

import com.gardener.comment.dto.Comment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Post {
	private int postNum; // 글번호
	private int userId; // 회원.아이디(번호)
	private String mainTitle; // 제목
	private String subTitle; // 소제목
	private String content; // 내용
	private String mainTitleImg; // 제목이미지
	private String category; // 카테고리
	private int postPublic; // 비공개,공개(0,1)
	private int favorite; // 좋아요
	private String createPost; // 글 생성일자
	private Comment contentTable; // 댓글 dto

	public Post(int postNum, int userId, String mainTitle, String subTitle, String content, String mainTitleImg,
			String category, int postPublic, int favorite, String createPost) {
		super();
		this.postNum = postNum;
		this.userId = userId;
		this.mainTitle = mainTitle;
		this.subTitle = subTitle;
		this.content = content;
		this.mainTitleImg = mainTitleImg;
		this.category = category;
		this.postPublic = postPublic;
		this.favorite = favorite;
		this.createPost = createPost;
	}

	@Override
	public String toString() {
		return "Post [postNum=" + postNum + ", userId=" + userId + ", mainTitle=" + mainTitle + ", subTitle=" + subTitle
				+ ", content=" + content + ", mainTitleImg=" + mainTitleImg + ", category=" + category + ", postPublic="
				+ postPublic + ", favorite=" + favorite + ", createPost=" + createPost + "]";
	}

}
