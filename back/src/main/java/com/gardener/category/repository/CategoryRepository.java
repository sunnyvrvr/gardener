package com.gardener.category.repository;

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

public class CategoryRepository {
private SqlSessionFactory sessionFactory;
	
	public CategoryRepository(){
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);			
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {			
			e.printStackTrace();
		}	
	}
	
	
	//메서드 작성
	public List<Search> selectCategory(String category) throws FindException{
		SqlSession session = null;
		List<Search> categoryList = new ArrayList<>();
		
		session = sessionFactory.openSession();
		categoryList = session.selectList("com.gardener.SearchMapper.selectcategory",category);
		
		if(categoryList==null) {
			throw new FindException("해당 카테고리의 글이 없습니다.");
		}else {
			return categoryList;				
		}
		
		
	}
	
	
	
	
}
