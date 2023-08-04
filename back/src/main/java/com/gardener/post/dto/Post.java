package com.gardener.post.dto;

import com.gardener.member.dto.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Post {
	private int id; // 글번호
	private int memberId; // 회원.아이디(번호)
	private String mainTitle; // 제목
	private String subTitle; // 소제목
	private String content; // 내용
	private String mainTitleImg; // 제목이미지
	private String category; // 카테고리
	private int postPublic; // 비공개,공개(0,1)
	private int favorite; // 좋아요
	private String createPost; // 글 생성일자

	private Member member;
	// private Comment contentTable; // 댓글 dto

	public Post(int id, int memberId, String mainTitle, String subTitle, String content, String mainTitleImg,
			String category, int postPublic, int favorite, String createPost) {
		this.id = id;
		this.memberId = memberId;
		this.mainTitle = mainTitle;
		this.subTitle = subTitle;
		this.content = content;
		this.mainTitleImg = mainTitleImg;
		this.category = category;
		this.postPublic = postPublic;
		this.favorite = favorite;
		this.createPost = createPost;
	}

}
