package com.gardener.member.repository;


import com.gardener.member.dto.Member;

public class MemberRepository {
	 private static MemberRepository repository = new MemberRepository();

	public Member findById(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

}

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gardener.exception.FindException;
import com.gardener.member.dto.Member;

public class MemberRepository {
	private SqlSessionFactory sessionFactory;
	public MemberRepository(){
		String resource ="/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);			
			sessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {			
			e.printStackTrace();
		}	
	}
	
	public Member selectById(String id) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			Member m = session.selectOne("com.my.member.mapper.MemberMapper.selectById", id);
			if(m == null) {
				throw new FindException("");
			}
			System.out.println("m.id=" + m.getId() + ", m.pwd=" + m.getPwd() + ",m.name=" + m.getName());
			return m;		
		}catch(Exception e) {
			e.printStackTrace();
			throw new FindException (e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}			
		}		
	
		
		
		
	}
}

//	public void insert(Member m) {
//		SqlSession session = null;
//		session = sessionFactory.openSession();
//		Map<String, String> map = new HashMap<>();
//		}

