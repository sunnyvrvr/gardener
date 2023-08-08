package com.gardener.member.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Member {
   
   private int id;      //아이디
   private String loginId; //로그인아이디
   private String pwd;     //패스워드
   private String email;   //이메일
   private String name;    //필명
   private String intro;   //자기소개
   private String joinDate;   //가입날짜
   private String profile; //프로필사진 
   
   
   public Member(String loginId, String pwd, String email, String name) {
	this.loginId = loginId;
	this.pwd = pwd;
	this.email = email;
	this.name = name;
   }
      
}
