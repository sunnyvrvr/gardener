package com.gardener.post.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

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
			session.insert("com.gardener.PostMapper.insertPost", post);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Post selectByPost(int id) {
		SqlSession session = null;
		Post post = new Post();
		Map<Integer, Post> map = new HashMap<>();
		try {
			session = sessionFactory.openSession();
			System.out.println(id);
			post = session.selectOne("com.gardener.PostMapper.selectPost", id);
			System.out.println(post);
		} catch (Exception e) {
			System.out.println("post 없어. 아마?");
			e.printStackTrace();
		}
		return post;
	}
}
