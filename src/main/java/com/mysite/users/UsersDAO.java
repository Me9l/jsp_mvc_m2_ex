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
	private final String GET_USER = "SELECT * FROM users WHERE id=?";
	private final String UPDATE_USER = "UPDATE users SET pw=?,role=? WHERE id=?";
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
	
	public UsersDTO getUser(UsersDTO dto) {
		System.out.println("getUser request");
		UsersDTO user = new UsersDTO();
		try {
			conn = JDBCutil.getConnection();
			pstmt = conn.prepareStatement(GET_USER);
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				user.setId(rs.getString("ID"));
				user.setPw(rs.getString("PW"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(rs, pstmt, conn);
		}
		return user;
	}
	
//		UPDATE_USER = "UPDATE users SET pw=?,role=? WHERE id=?";
	public void updateUser(UsersDTO dto) {
		System.out.println("updateUser processing..");
		try {
			conn = JDBCutil.getConnection();
			pstmt = conn.prepareStatement(UPDATE_USER);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getRole());
			pstmt.setString(3, dto.getId());
			
			pstmt.executeUpdate();
			
			System.out.println("User Update Complete");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(pstmt, conn);
		}
	}
}
