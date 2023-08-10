package com.gardener.member.service;

import com.gardener.member.dto.Member;
import com.gardener.member.repository.MemberMypageRepository;
import com.gradener.exception.FindException;
import com.gradener.exception.UpdateException;

public class MemberMypageService {
	private static MemberMypageService service = new MemberMypageService();
	private MemberMypageRepository repository;

	private MemberMypageService() {
		repository = new MemberMypageRepository();
	}

	public static MemberMypageService getInstance() {
		return service;
	}
	//회원찾기 시작
		public void findMember(Member m) {
			try {
				repository.findMember(m);
			} catch (FindException e) {			
				e.printStackTrace();
			}

		}

		public Member findByMember(String loginId)throws FindException {
			try {
		        Member m = new Member();
		        m.setId(loginId);
		        repository.findMember(m);
		        return m;
		    } catch (FindException e) {
		        throw new FindException("Error occurred while finding member: " + e.getMessage());
		    }
		}
		public Member findByMember(Object attribute) {
			// TODO Auto-generated method stub
			return null;
		}
		//회원찾기 끝
		
		//회원 수정하기 시작
		public void updateMember(Member m) throws UpdateException {
			try {
				repository.updateMember(m);
			} catch (UpdateException e) {		
				throw e;
			}
			
		}
		//회원 수정하기 끝
		
		//회원탈퇴 시작
	    public boolean deleteMember(String loginId) {
			
			return repository.deleteMember(loginId);
		}
	  //회원탈퇴 끝


	}