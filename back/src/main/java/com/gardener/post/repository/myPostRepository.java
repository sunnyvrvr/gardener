package com.gardener.post.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gardener.post.dto.Post;
import com.my.exception.FindException;

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
	 * @param 작성자 id에 해당하는 글을 반환한다
	 * @return List<Post>
	 * @throws FindException 
	 */
	public List<Post> selectById(String mainTitle) throws FindException {		
		SqlSession session = null;
			System.out.println(mainTitle+" --");
			session = sessionFactory.openSession();
			List<Post> result = new ArrayList<Post>(); //list 선언추가 
			result = session.selectList("com.gardener.PostMapper.selectById", mainTitle);
			result.forEach(e->System.out.println(e)); //내용확인
			for(int i=0; i<result.size(); i++) {
				
			}
			//listPost = session.selectList("com.gardener.PostMapper.selectById", mainTitle);
			System.out.println("session 연결 성공");
			if(result.size() == 0) {
				throw new FindException("글이 없습니다");
			}
			return result;
	}
	/**
	 * 
	 * @param loginid
	 * @return result 리스트
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
				throw new FindException("글이 없습니다");
			}
			return result;
	}
}
