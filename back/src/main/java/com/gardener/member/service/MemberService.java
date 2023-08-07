package com.gardener.member.service;

import com.gardener.member.dto.Member;
import com.gardener.member.repository.MemberRepository;
import com.gradener.exception.FindException;
import com.gradener.exception.UpdateException;

public class MemberService {
	private static MemberService service = new MemberService();
	private MemberRepository repository;

	private MemberService() {
		repository = new MemberRepository();
	}

	public static MemberService getInstance() {
		return service;
	}
    //회원 수정하기 시작
	public void updateMember(Member m) throws UpdateException {
		try {
			repository.updateMember(m);
		} catch (UpdateException e) {		
			throw e;
		  }

	}
	//회원 수정하기 끝
	
	//회원찾기 시작
	public void findMember(Member m) {
		try {
			repository.findMember(m);
		} catch (FindException e) {			
			e.printStackTrace();
		}

	}
 
	public Member findByMember(Object attribute) {
		return null;
	}

	public Member findByMember(String loginId) {
		return null;
	}
	//회원찾기 끝
	
	
	//회원탈퇴 시작
    public boolean deleteMember(String userId) {
		
		return repository.deleteMember(userId);
	}
  //회원탈퇴 끝

}
