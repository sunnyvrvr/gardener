package com.gardener.member.repository;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gardener.exception.AddException;
import com.gardener.exception.FindException;
import com.gardener.member.dto.Member;

public class MemberRepository {
	private SqlSessionFactory sessionFactory;

	public MemberRepository() {
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//로그인, 중복확인
	public Member selectById(String loginId) throws FindException {
		SqlSession session = null;
		System.out.println(loginId+"Repository");
		session = sessionFactory.openSession();

			Member m = session.selectOne("com.gardener.MemberMapper.selectById", loginId);
			try {
				System.out.println("연결성공");
				return m;
			} catch (Exception e) {
				if (m == null) {
					throw new FindException("저장된 고객 정보가 없습니다");
				}
			}
			return m;
			
//			if (m == null) {
//				throw new FindException("저장된 고객 정보가 없습니다");
//			} else {
////			System.out.println(m.getId() + ", m.pwd=" + m.getPwd() + ",m.name=" + m.getName());
//			System.out.println("연결성공");
//			return m;
//			}
	}

	//회원가입
	public void signup(Member m) throws AddException {
		SqlSession session = null;
		System.out.println(m.getLoginId());
		System.out.println(m.getPwd());
		System.out.println(m.getEmail());
		System.out.println(m.getName());
		System.out.println(m.getIntro());
		try {
			session = sessionFactory.openSession();
			session.insert("com.gardener.MemberMapper.signup", m);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} 
	}
}