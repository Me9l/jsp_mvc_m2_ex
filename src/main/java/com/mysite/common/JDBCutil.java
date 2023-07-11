package com.mysite.common;

import java.sql.*;

// 여러 도메인(패키지)에서 공통으로 사용할 클래스

// DB Connection Class
public class JDBCutil {
	public JDBCutil(){	// 기본 생성자.
		System.out.println("JDBCutil Class has called.");
	}
	// 3개의 메소드 모두 static 으로 객체 생성 없이 클래스 이름으로 호출해서 사용.
	// 1. DataBase Connection method.
	public static Connection getConnection() {
		Connection conn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			Class.forName(driver);	// 해당경로에 OracleDriver 클래스가 존재하는지 확인
			conn = DriverManager.getConnection(url, "C##HR2", "1234");
			System.out.println("Connected : " + conn);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection Failed : " + conn);
		}
		
		return conn;
	}
	// 2. DataBase Disconnection method. ( PreparedStatement, Connection )
		// insert , update, delete 요청시
	public static void close(PreparedStatement pstmt, Connection conn) {
		// PreparedStatement 객체 close.
		if ( pstmt != null ) {	// pstmt가 null 이 아닐때
			try {
				if ( !pstmt.isClosed() ) {	// pstmt가 close가 아닐때
					pstmt.close();
				}
				System.out.println("PreparedStatement has closed.");
			} catch (Exception e) {
				System.out.println("PreparedStatement close Failed.");
			}
		}
		
		// Connection 객체 close.
		
		if ( conn != null ) {	// conn가 null 이 아닐때
			try {
				if ( !conn.isClosed() ) {	// conn이 close가 아닐때
					conn.close();
				}
				System.out.println("Connection has closed.");
			} catch (Exception e) {
				System.out.println("Connection close Failed.");
			}
		}
	}
	
	
	// 3. DataBase Disconnection method. ( ResultSet , PreparedStatement, Connection )
		// select 요청시

	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {

		if ( rs != null ) {	// pstmt가 null 이 아닐때
			try {
				if ( !rs.isClosed() ) {	// pstmt가 close가 아닐때
					rs.close();
				}
				System.out.println("ResultSet has closed.");
			} catch (Exception e) {
				System.out.println("ResultSet close Failed.");
			}
		}
		
		// PreparedStatement 객체 close.
		if ( pstmt != null ) {	// pstmt가 null 이 아닐때
			try {
				if ( !pstmt.isClosed() ) {	// pstmt가 close가 아닐때
					pstmt.close();
				}
				System.out.println("PreparedStatement has closed.");
			} catch (Exception e) {
				System.out.println("PreparedStatement close Failed.");
			}
		}
		
		// Connection 객체 close.
		
		if ( conn != null ) {	// conn가 null 이 아닐때
			try {
				if ( !conn.isClosed() ) {	// conn이 close가 아닐때
					conn.close();
				}
				System.out.println("Connection has closed.");
			} catch (Exception e) {
				System.out.println("Connection close Failed.");
			}
		}
	}
	
}
