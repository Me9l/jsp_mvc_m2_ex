package com.mysite.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysite.common.JDBCutil;

public class UsersDAO {
	private Connection conn ;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private final String USERS_INSERT = "INSERT INTO users (id,pw,name,role) VALUES(?,?,?,?)";
	private final String GET_ALL_USERS = "SELECT * FROM users ORDER BY id ASC";
	// 1. method for INSERT VALUES INTO users table
	public void insertUsers(UsersDTO dto) {
		System.out.println("try insert Users...");
		try {
			conn = JDBCutil.getConnection();
			pstmt = conn.prepareStatement(USERS_INSERT);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getRole());
			
			pstmt.executeUpdate();
			System.out.println("insert user success.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(pstmt, conn);
		}
		
	}

	// 2. method for SELECT * FROM users table
	public List<UsersDTO> getUsersList(UsersDTO dto){
		// userList를 담을 객체 생성.
		List<UsersDTO> usersList = new ArrayList<UsersDTO>();
		
		try {
			conn = JDBCutil.getConnection();
			pstmt = conn.prepareStatement(GET_ALL_USERS);
			rs = pstmt.executeQuery();
			
			while ( rs.next() ) {				
				UsersDTO users = new UsersDTO();
				users.id = rs.getString("id");
				users.pw = rs.getString("pw");
				users.name = rs.getString("name");
				users.role = rs.getString("role");
				
				usersList.add(users);
			}
			System.out.println("usersList setting complete.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(rs, pstmt, conn);
		}
		
		return usersList;
	}
}
