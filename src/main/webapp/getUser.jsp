<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.mysite.users.UsersDTO" %>
<% UsersDTO dto = (UsersDTO)session.getAttribute("getUser"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> user </title>
<style>
	.userTable {
		width : 700px;
		margin : 0 auto;
	}
</style>
</head>
<body>
	<div class="userTable">
		<h3> 회원 정보 </h3>
		<form action="updateUser.do" method="post">
		<input type="hidden" name="id" value="<%=dto.getId()%>">
		<table border="1px" cellpadding="0" cellspacing="0" width="600px">
			<tr bgcolor="orange">
				<th width="200px">아이디</th>
				<th width="100px">비밀번호</th>
				<th width="200px">이름</th>
				<th width="100px">권한</th>
			</tr>
			<tr>
				<td align="center"><%= dto.getId() %></td>
				<td><input type="text" name="pw" value="<%= dto.getPw() %>"></td>
				<td align="center"> <%= dto.getName() %> </td>
				<td><input type="text" name="role" value="<%= dto.getRole() %>"></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="submit" value="수정하기">
					<input type="button" value="목록">
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>