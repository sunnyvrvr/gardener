package com.my.gardener.member.service;

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

}
