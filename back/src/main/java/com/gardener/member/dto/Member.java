package com.gardener.member.dto;

<<<<<<< HEAD
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Member {
   
   private int id;      //¾ÆÀÌµğ
   private String loginId; //·Î±×ÀÎ¾ÆÀÌµğ
   private String pwd;     //ÆĞ½º¿öµå
   private String email;   //ÀÌ¸ŞÀÏ
   private String name;    //ÇÊ¸í
   private String intro;   //ÀÚ±â¼Ò°³
   private String joinDate;   //°¡ÀÔ³¯Â¥
   private String profile; //ÇÁ·ÎÇÊ»çÁø 
   
   
=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Member {
	 private String id;      		//ì•„ì´ë””
	 private String pwd;     		//íŒ¨ìŠ¤ì›Œë“œ
	 private String email;   		//ì´ë©”ì¼
	 private String name;   		//í•„ëª…
	 private String intro;  		//ìê¸°ì†Œê°œ
	 private String joinDate;   	//ê°€ì…ë‚ ì§œ
	 private String profile; 		//í”„ë¡œí•„ì‚¬ì§„ 
>>>>>>> 21611a7624e77cf682f16ae501571903703724c6
}
