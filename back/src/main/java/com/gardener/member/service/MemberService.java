package com.gardener.member.service;

import com.gardener.exception.FindException;
import com.gardener.member.dto.Member;
import com.gardener.member.repository.MemberRepository;

public class MemberService {
	static private MemberService service = new MemberService();
	private MemberRepository repository;
	//selectbyId - 로그인함수, service에서는 login으로 변경
	private MemberService() {
		repository = new MemberRepository();
	}
	public static MemberService getInstance() {
		return service;
	}
	public Member login(String loginId, String pwd) throws FindException {
		Member m = repository.selectById(loginId);
		System.out.println(loginId+"Service");
		if (pwd.equals(m.getPwd())) {
			return m; // 로그인 성공
		} else {
			throw new FindException("로그인 실패");
		}
	}
	
	
}
