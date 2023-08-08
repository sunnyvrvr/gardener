package com.gardener.member.service;
import com.gardener.exception.AddException;
import com.gardener.exception.FindException;
import com.gardener.member.dto.Member;
import com.gardener.member.repository.MemberRepository;

import com.gardener.member.dto.Member;
import com.gardener.member.repository.MemberRepository;

public class MemberService {
	private static MemberService service = new MemberService();
	private MemberRepository repository;


	private MemberService() {
		repository = new MemberRepository();
	}

	public static MemberService getInstance() {
		return service;
	}

	public Member findByMember(String memberId) {
		// 회원 정보 조회 로직 구현
//		return repository.findById(memberId);
		return null;
	}

	
	public Member login (String loginId, String pwd) throws FindException {
		Member m = repository.selectById(loginId);
		if(pwd.equals(m.getPwd())) {
			return m; // 로그인성공
		}else {
			throw new FindException("로그인 실패");
		}
	}
	
	public void signup(Member m) throws AddException {
		repository.insert(m);
	}
			
}
