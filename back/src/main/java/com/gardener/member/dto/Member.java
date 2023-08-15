package com.gardener.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Member{
	String loginId;
	String pwd;
	String email;
	String name; 
	String intro;
}
