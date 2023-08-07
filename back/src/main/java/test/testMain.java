package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gardener.exception.FindException;
import com.gardener.search.controller.SearchController;
import com.gardener.search.dto.Search;
import com.gardener.search.repository.SearchRepository;
import com.gardener.search.service.SearchService;
import com.google.gson.Gson;

public class testMain {
	
	
	public static void main(String[] args) throws FindException {
		SqlSessionFactory sessionFactory = null;
		String resource ="/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);			
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {			
			e.printStackTrace();
		}	
				//selectOption값 가져오기
				String select = "title";
				
				//input[type=text]값 가져오기
				String searchKeyword = "test";
				
				//Search result = new Search();
				//Gson gson = new Gson();
//				List<Search> result = new ArrayList<>();
				
				SqlSession session = null;
				
				//제목으로 검색한 결과를 저장할 리스트
				List<Search> titleList = new ArrayList<>();
				
					session = sessionFactory.openSession();
					titleList = session.selectList("com.gardener.SearchMapper.searchtitle","%"+searchKeyword+"%");
					
					if(titleList==null) {
						throw new FindException("해당제목은 없습니다.");
					}else {
						System.out.println("titleList = "+titleList.size());
					}	
			
				
					

				
	}

}
