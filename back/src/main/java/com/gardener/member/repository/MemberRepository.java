package com.gardener.member.repository;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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

	public Member selectById(String id) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			Member m = session.selectOne("com.my.member.mapper.MemberMapper.selectById", id);
			if (m == null) {
				throw new FindException("");
			}
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
}
