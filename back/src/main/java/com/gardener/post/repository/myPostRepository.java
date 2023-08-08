package com.gardener.post.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
	 * @param ���깆�� id�� �대�뱁���� 湲��� 諛�������
	 * @return List<Post>
	 * @throws FindException 
	 */
	public List<Post> selectById(String mainTitle) throws FindException {		
		SqlSession session = null;
			System.out.println(mainTitle+" --");
			session = sessionFactory.openSession();
			List<Post> result = new ArrayList<Post>(); //list ���몄�媛� 
			result = session.selectList("com.gardener.PostMapper.selectById", mainTitle);
			result.forEach(e->System.out.println(e)); //�댁�⑺����
			for(int i=0; i<result.size(); i++) {
				
			}
			//listPost = session.selectList("com.gardener.PostMapper.selectById", mainTitle);
			System.out.println("session �곌껐 �깃났");
			if(result.size() == 0) {
				throw new FindException("湲��� ���듬����");
			}
			return result;
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
			List<Post> result = new ArrayList<Post>(); //list ����
			result = session.selectList("com.gardener.PostMapper.selectByLoginid", loginid);
			//result.forEach(e->System.out.println(e)); //�댁�⑺����
			System.out.println("session �곌껐 �깃났");
			if(result.size() == 0) {
				throw new FindException("湲��� ���듬����");
			}
			return result;
	}
}
