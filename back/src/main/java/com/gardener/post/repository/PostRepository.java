package com.gardener.post.repository;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gardener.post.dto.Post;

public class PostRepository {

	private SqlSessionFactory sessionFactory;

	public PostRepository() {
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println(sessionFactory + " -- > sessionFactory ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void insertPost(Post post) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			System.out.println(session + " -- repo session 확인");
			session.insert("com.gardener.PostMapper.insertPost", post);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
