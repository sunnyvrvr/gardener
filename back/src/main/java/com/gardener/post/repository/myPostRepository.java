package com.gardener.post.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import com.gardener.member.dto.Member;

import com.gardener.exception.FindException;

import com.gardener.post.dto.Post;

public class myPostRepository {
	private SqlSessionFactory sessionFactory;
	public myPostRepository() {
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


	/**
	 * 
	 * @param loginid
	 * @return result 由ъ�ㅽ��
	 * @throws FindException
	 */
	public List<Post> selectByLoginid(String loginid) throws FindException {		
			SqlSession session = null;
			System.out.println(loginid+" --");
			session = sessionFactory.openSession();

			List<Post> result = new ArrayList<Post>(); //list 생성
			result = session.selectList("com.gardener.PostMapper.selectByLoginid", loginid);
			//result.forEach(e->System.out.println(e)); //내용확인
			System.out.println("session 연결 성공");
			if(result.size() == 0) {
				throw new FindException("글없음");
			}
			return result;
	}

	
}
