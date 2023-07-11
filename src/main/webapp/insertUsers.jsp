<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join us</title>
<style>
	.userTable {
		width : 500px;
		margin : 0 auto;
	}
</style>
</head>
<body>
	<div class="userTable">
	<form action="insertUsers.do">
		<table border="1px" cellpadding="0" cellspacing="0">
			<tr>
				<th> 아이디 : </th>
				<td>
					<input type="text" name="id" maxlength="10">
				</td>
			</tr>
			<tr>
				<th> 비밀번호 : </th>
				<td>
					<input type="password" name="pw">
				</td>
			</tr>
			<tr>
				<th> 이름 : </th>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value=" 회원 가입 " />
				</td>
			</tr>
		</table>
	</form>
			<a href="getUsersList.do"> 사용자목록 </a>
	</div>
</body>
</html>