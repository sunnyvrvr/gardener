package com.gardener.post.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void insertPost(Post post) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			session.insert("com.gardener.post.PostMapper.insertPost", post);
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

	public void insertImgs(String[] imgs) {
		SqlSession session = null;
		Map<String, String> imgMap = new HashMap<>();
		for (int i = 0; i < imgs.length; i++) {
			imgMap.put("img" + i, imgs[i]);
		}

		Set<Map.Entry<String, String>> entries = imgMap.entrySet();
		entries.forEach(e -> System.out.println("k " + e.getKey() + " v: " + e.getValue()));

		try {
			session = sessionFactory.openSession();
			session.insert("com.gardener.post.PostMapper.insertImgs", imgMap);
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

	public Optional<Post> selectById(int id) {
		SqlSession session = null;
		Optional<Post> post = Optional.empty();
		try {
			session = sessionFactory.openSession();
			post = Optional.ofNullable(session.selectOne("com.gardener.post.PostMapper.selectPost", id));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return post;
	}

	public List<Post> selectAllPosts() {
		SqlSession session = null;
		List<Post> posts = new ArrayList<>();
		try {
			session = sessionFactory.openSession();
			posts = (ArrayList) session.selectList("com.gardener.post.PostMapper.selectAllPosts");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return posts;
	}

	public void updatePost(Post post) {
		System.out.println(post.getPostNum());
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			int update = session.update("com.gardener.post.PostMapper.updatePost", post);
			System.out.println(update + " -- update result");
			session.commit();
		} catch (Exception e) {
			System.out.println("업데이트 예=외");
			session.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
