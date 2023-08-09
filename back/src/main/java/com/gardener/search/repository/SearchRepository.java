package com.gardener.search.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gardener.exception.FindException;
import com.gardener.search.dto.Search;

public class SearchRepository {
	
	private SqlSessionFactory sessionFactory;
	
	public SearchRepository(){
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);			
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {			
			e.printStackTrace();
		}	
	}
	
	//검색한 결과를 저장할 리스트
	List<Search> searchResult = new ArrayList<Search>();
	
	/**
	 * 제목으로 검색
	 */
	public List<Search> searchTitle(String title) throws FindException {
		SqlSession session = null;
		searchResult = null;
		
		System.out.println("repository에서 받은 titleText = "+title);
		
			session = sessionFactory.openSession();
			searchResult = session.selectList("com.gardener.SearchMapper.searchtitle",title);
			
			if(searchResult==null) {
				throw new FindException("해당제목은 없습니다.");
			}else {
				return searchResult;				
			}
		
		}//searchTitle end
	
	/**
	 * 필명으로 검색
	 * @throws FindException 
	 */
	public List<Search> searchName(String name) throws FindException {
			SqlSession session = null;
			searchResult = null;
	
			System.out.println("repository에서 받은 nameText = "+name);
			
			session = sessionFactory.openSession();
			searchResult = session.selectList("com.gardener.SearchMapper.searchname",name);
				
			if(searchResult==null) {
				throw new FindException("해당작가는 없습니다.");
			}else {
				return searchResult;				
			}
	}//searchName end
	
	/**
	 * 내용으로 검색
	 * @throws FindException 
	 */
	public List<Search> searchContent(String content) throws FindException {
		SqlSession session = null;
		searchResult = null;
		
		System.out.println("repository에서 받은 contentText = "+content);
		
		session = sessionFactory.openSession();
		searchResult = session.selectList("com.gardener.SearchMapper.searchcontent",content);
			
		if(searchResult==null) {
			throw new FindException("해당내용은 없습니다.");
		}else {
			return searchResult;				
		}
	}//searchContent end
	
	/**
	 * text에 아무것도 입력 안했을때 전체 글 보여주기
	 * @throws FindException 
	 */
	public List<Search> selectAll() throws FindException {
		SqlSession session = null;
		searchResult = null;
		
		session = sessionFactory.openSession();
		searchResult = session.selectList("com.gardener.SearchMapper.selectall");
			
		if(searchResult==null) {
			throw new FindException("글이 없습니다.");
		}else {
			return searchResult;	
		}
	}
	

}
