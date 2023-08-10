package com.gardener.member.repository;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gardener.member.dto.Member;
import com.gradener.exception.FindException;
import com.gradener.exception.UpdateException;

public class MemberMypageRepository {
	private SqlSessionFactory sessionFactory;

	public MemberMypageRepository() {
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Member selectById(String id) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			Member m = session.selectOne("com.gardener.member.MemberMapper.selectById", id);
			if (m == null) {
				throw new FindException("");
			}
			System.out.println("m.id=" + m.getId() + ", m.pwd=" + m.getPwd() + ",m.name=" + m.getName());
			return m;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
    //회원찾기
	public void findMember(Member m) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			Member foundMember = session.selectOne("com.gardener.member.MemberMapper.selectByLoginId", m.getLoginId());
			if (foundMember == null) {
				throw new FindException("Member not found");
			}	
			// 조회된 회원 정보를 주어진 Member 객체에 업데이트
			m.setLoginId(foundMember.getLoginId());
			m.setPwd(foundMember.getPwd());
			m.setEmail(foundMember.getEmail());
			m.setName(foundMember.getName());
			m.setIntro(foundMember.getIntro());
			m.setProfile(foundMember.getProfile());
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
 
	//회원수정하기
	public void updateMember(Member m) throws UpdateException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			int result = session.update("com.gardener.member.MemberMapper.updateMember", m);
			if (result == 0) {
				throw new UpdateException("Failed to update member information");
			}
			session.commit(); // 변경 사항 커밋
		} catch (Exception e) {
			e.printStackTrace();
			throw new UpdateException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//회원탈퇴하기 
	public boolean deleteMember(String loginId) {
		SqlSession session = null;
        try {
            session = sessionFactory.openSession();
            System.out.println("delete:" + loginId);
            int rowsDeleted = session.delete("com.gardener.member.MemberMapper.deleteMember", loginId);
           
            if (rowsDeleted > 0) {
                session.commit();
                return true; // 회원 탈퇴 성공
            } else {
                session.rollback();
                return false; // 회원 탈퇴 실패 (삭제된 행이 없는 경우)
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 회원 탈퇴 실패 (예외 발생)
        } finally {
            if (session != null) {
                session.close();
            }
        }
	}
}
