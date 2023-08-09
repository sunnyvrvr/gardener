package com.garderner.writer.repository;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gardener.member.dto.Member;

public class WriterRepository {
	private SqlSessionFactory sessionFactory;
	public WriterRepository() {
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;

		try {
			inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void selectByWriter(int writerid) {
		SqlSession session = null;
		session = sessionFactory.openSession();
		Member m = new Member();
		m = session.selectOne("com.gardener.WriterMapper.selectByWriter", writerid);
	}
}

