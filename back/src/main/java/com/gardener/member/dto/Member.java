package com.gardener.member.dto;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	private int id; // pk
	private String loginId; // 아이디
	private String pwd; // 패스워드
	private String email; // 이메일
	private String name; // 필명
	private String intro; // 자기소개
	private String joinDate; // 가입날짜
	private String profile; // 프로필사진

	public Member(String loginId, String pwd, String email, String name, String intro, String profile) {
		this.loginId = loginId;
		this.pwd = pwd;
		this.email = email;
		this.name = name;
		this.intro = intro;
		this.profile = profile;
	}

	public String toJsonString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}
