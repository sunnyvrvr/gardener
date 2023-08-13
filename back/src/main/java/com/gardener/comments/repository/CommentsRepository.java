package com.gardener.comments.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gardener.comments.dto.Comments;

public class CommentsRepository {
	private SqlSessionFactory sessionFactory;

	public CommentsRepository() {
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;

		try {
			inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void insertReply(Comments comments) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			int insert = session.insert("com.gardener.comments.CommentsMapper.insertComments", comments);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Comments> selectAll(int startRow, int endRow, int num) {
		System.out.println("repo num = " + num);
		List<Comments> list = new ArrayList();
		SqlSession session = null;
		Map<String, Integer> map = new HashMap();
		System.out.println(num + " -- repo num");
		try {
			session = sessionFactory.openSession();
			map.put("startRow", startRow);
			map.put("endRow", endRow);
			map.put("num", num);
			list = session.selectList("com.gardener.comments.CommentsMapper.selectAll", map);
			System.out.println(list.size() + " -- comments list size repo");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		list.forEach(e -> System.out.println(e + " -- list"));
		return list;
	}

	public int count(int num) {
		SqlSession session = null;
		int count = 0;
		try {
			session = sessionFactory.openSession();
			count = session.selectOne("com.gardener.comments.CommentsMapper.count", num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return count;
	}

}
