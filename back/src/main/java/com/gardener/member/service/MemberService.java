package com.gardener.member.service;

import com.gardener.exception.AddException;
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
	public void signup(Member m) throws AddException {
		repository.signup(m);
	}
	public void idDupChk(String loginId) throws FindException {
		Member m = null;
		try {
			// loginId에 해당 고객이 있는 경우(중복인 경우)
			m = repository.selectById(loginId);
		} catch (FindException e) {
			// loginId에 해당 고객이 없는 경우(id 사용가능한 경우)
			if (m != null) {
				throw new FindException("이미 사용중인 아이디 입니다");
			} 
		}

	}
	
}
