package com.mysite.test;

import com.mysite.users.UsersDAO;
import com.mysite.users.UsersDTO;

public class Insert_User_Test {

	public static void main(String[] args) {
		UsersDTO dto = new UsersDTO();
		UsersDAO dao = new UsersDAO();
		dto.setId("test_Id");
		dto.setPw("test_Pw");
		dto.setName("test_Name");
		dto.setRole("test_Role");
		
		dao.insertUsers(dto);
		
		System.out.println(dao.getUsersList(dto));
	}

}
