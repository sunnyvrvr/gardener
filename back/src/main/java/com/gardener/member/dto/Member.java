package com.gardener.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Member {
	private int id;
	private String loginId;
	private String pwd;
	private String email;
	private String name;
	private String intro;
	private int deleteYn;
	private String joinDate;
	private String profile;

	// 게시글 불러올때 사용할 생성자
	public Member(String name, String intro, String profile) {
		this.name = name;
		this.intro = intro;
		this.profile = profile;
	}
}
