package com.gardener.writer.respository;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class WriterRepository {

	SqlSessionFactory sessionFactory;

	public WriterRepository() {
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 작가 신청서보내기 시작
	public boolean insertWriter(int id) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();

			// 시퀀스 값을 저장하는 로직 (이 부분은 실제로는 시퀀스 값을 얻어오는 방법에 따라 구현되어야 합니다.)

			int rowsInserted = session.insert("com.gardener.writer.WriterMapper.insertWriter", id);
			if (rowsInserted > 0) {
				session.commit();
				return true; // 작가 정보 등록 성공
			} else {
				session.rollback();
				return false; // 작가 정보 등록 실패
			}
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
			return false; // 작가 정보 등록 실패
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// 작가 신청서보내기 끝

	// 작가 신청 취소하기 시작
	public boolean cancelWriter(int id) {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();

			int rowsDeleted = session.delete("com.gardener.writer.WriterMapper.cancelWriter", id);

			if (rowsDeleted > 0) {
				session.commit();
				return true; // 작가 정보 삭제 성공
			} else {
				session.rollback();
				return false; // 작가 정보 삭제 실패
			}
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
			return false; // 작가 정보 삭제 실패
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
	// 작가 신청 취소하기 끝
 
	
	}
