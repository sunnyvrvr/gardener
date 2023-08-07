package test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gardener.exception.FindException;
import com.gardener.search.dto.Search;

import JDBC.MyConnection;

public class SearchRepositoryTest {
	
	private SqlSessionFactory sessionFactory;
	
	public SearchRepositoryTest(){
		String resource ="/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);			
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {			
			e.printStackTrace();
		}	
	}
	
	/**
	 * 제목으로 검색
	 */
	public List<Search> searchTitle(String title) throws FindException {
		SqlSession session = null;
		
		//제목으로 검색한 결과를 저장할 리스트
		List<Search> titleList = new ArrayList<>();
		
		try {
			session = sessionFactory.openSession();
			titleList = session.selectList("com.gardener.SearchMapper.searchtitle","%"+title+"%");
			
			if(titleList==null) {
				throw new FindException("해당제목은 없습니다.");
			}else {
				return titleList;
			}	
			
		}catch(Exception e) {
			throw new FindException("제목검색 실패:" + e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		
	}
	
	
	
	
	
	
//	Search search = new Search();
//	
//	Connection conn = null;
//	
//	public void searchTitle(String title) throws FindException {
//		try {
//			conn = MyConnection.getConnection();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//	
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//	try {
//		String selectSQL = "SELECT name, maintitle, content, maintitleimg\r\n"
//				+ "FROM MEMBER m JOIN POST p ON(m.usernum = p.usernum)\r\n"
//				+ "WHERE maintitle LIKE ?"; 
//		
//		pstmt = conn.prepareStatement(selectSQL);
//		pstmt.setString(1, "%" + title + "%");
//		rs = pstmt.executeQuery();
//		
//		while(rs.next()) {
//			System.out.println(rs.getString(1));
//			
//		}
//		System.out.println(title);
//
//		
//	} catch (SQLException e) {
//		e.printStackTrace();
//	} finally {
//		MyConnection.close(rs,pstmt,conn);
//	}
	
	
	
}
	


