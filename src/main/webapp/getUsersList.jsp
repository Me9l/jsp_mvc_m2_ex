<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="com.mysite.users.UsersDTO" %>

<%
	List<UsersDTO> usersList = new ArrayList<>();
	usersList = (List)session.getAttribute("usersList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> user List </title>
<style>
	.userTable {
		width : 500px;
		margin : 0 auto;
	}
</style>
</head>
<body>
	<div class="userTable">
		<h3> 회원 정보 </h3>
		<table border="1px" cellpadding="0" cellspacing="0" width="400px">
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>권한</th>
			</tr>
			
			<% for (UsersDTO dto : usersList) {%>
			<tr>
				<td> <%= dto.getId() %> </td>
				<td> <%= dto.getPw() %> </td>
				<td> <%= dto.getName() %> </td>
				<td> <%= dto.getRole() %> </td>
			</tr>
			<% }
				session.removeAttribute("usersList");
			%>
		</table>
		<a href="insertUsers.jsp">회원가입</a>
	</div>
</body>
</html>