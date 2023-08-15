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
	public List<Post> selectByLoginId(String loginId) throws FindException {		
			SqlSession session = null;
			System.out.println(loginId+" --");
			session = sessionFactory.openSession();
			List<Post> listPost = new ArrayList<Post>(); //list 생성
			
			listPost = session.selectList("com.gardener.PostMapper.selectByLoginId", loginId);
			//result.forEach(e->System.out.println(e)); //내용확인
			System.out.println("session 연결 성공");
	
			if(listPost.size() == 0) { //result.size == 0에서 변경
				throw new FindException("글없음");
			} else {
				return listPost;				
			}	
	}
}
