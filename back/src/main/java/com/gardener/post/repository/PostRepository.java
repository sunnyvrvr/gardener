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
			sessionFactory  =
					new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void selectById(String login_id) {
		SqlSession session = null;

			session = sessionFactory.openSession();
			Post p= session.selectOne("com.my.garder.mapper.PostMapper.selectByid", login_id);		

	}
}
