package com.gardener.writer.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gardener.exception.FindException;
import com.gardener.member.dto.Member;
import com.gardener.post.dto.Post;

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

	public Member selectByWriter(int writerid) {
		SqlSession session = null;
		session = sessionFactory.openSession();
		Member m = new Member();
		m = session.selectOne("com.gardener.WriterMapper.selectByWriter", writerid);
		return m;
	}
	public List<Post> selectByWriterPost(int writerid) throws FindException {
		SqlSession session = null;
		System.out.println(writerid+"--");
		session = sessionFactory.openSession();
		
		List<Post> WriterPost = new ArrayList<Post>(); //list 생성
		WriterPost = null;
		WriterPost = session.selectList("com.gardener.WriterMapper.selectByWriterPost", writerid);
		WriterPost.forEach(e->System.out.println(e)); //내용확인
		System.out.println("session 연결 성공");
		if(WriterPost.size() == 0) {
			throw new FindException("글없음");
		}
		return WriterPost;
	}
	public List<Member> subscribeWriter(String loginId) throws FindException {
		SqlSession session = null;
		System.out.println(loginId+"--");
		session = sessionFactory.openSession();
		
		List<Member>SubscribeWriter = new ArrayList<Member>();
		SubscribeWriter = session.selectList("com.gardener.WriterMapper.subscribeWriter", loginId);
		SubscribeWriter.forEach(e->System.out.println(e)); //내용확인		
		System.out.println("session 연결 성공");
		if(SubscribeWriter.size() == 0) {
			System.out.println("글없음"); //throws FindException 인가?
		}		
		return SubscribeWriter;
	}
}

