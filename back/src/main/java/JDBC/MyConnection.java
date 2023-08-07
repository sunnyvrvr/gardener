package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
	
	/**
	 * 1번 ~ 2번 작업을 해주는 메서드
	 * @return conn
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		//1번작업
		Class.forName("oracle.jdbc.OracleDriver");
		//2번작업
		Connection conn = null;
		String url = "jdbc:oracle:thin:@192.168.0.30:1521:xe";		
		String user = "gardener";
		String password = "1234";
		
		conn = DriverManager.getConnection(url,user,password);
		System.out.println("DB와 연결 성공");
		return conn;
		
		
	}//getConnection
	
	/**
	 * 6번작업 rs,stmt,conn을 닫는 메서드
	 * 자기가 직접 예외를 처리하는 메서드이다.
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		
	}//close
			
}//class
