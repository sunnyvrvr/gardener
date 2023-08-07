package com.gardener.member.service;

import com.gardener.exception.FindException;
import com.gardener.member.dto.Member;
import com.gardener.member.repository.MemberRepository;

public class MemberService {
	private static MemberService service = new MemberService();
	private MemberRepository repository;
	
	private MemberService () {
		repository = new MemberRepository();	
	}
	
	public static MemberService getInstance() {
		return 	service;	
	}
	
	public Member login (String id, String pwd) throws FindException {
		Member m = repository.selectById(id);
		if(pwd.equals(m.getPwd())) {
			return m; //로그인성공
		}else {
			throw new FindException("로그인 실패");
		}
	}
	
	public void signup(Member m) {	}
	


	
		
		
	
	
}
