<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.mysite.board.BoardDTO" %>
<% BoardDTO dto = (BoardDTO)session.getAttribute("getBoard"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Board Detail </title>
<style>
	.boardDetail {
		width : 700px;
		margin : 0 auto;
	}
</style>
</head>
<body>
	<div class="boardDetail">
	<form action="updateBoard.do" method="post">
	<!-- seq값을 저장하기위해 form 안에 hidden type의 button에 seq값 할당 -->
	<input type="hidden" name="seq" value="<%= dto.getSeq() %>">
	<h2> 게시글 수정 </h2>
		<table border="1px" cellpadding="0" cellspacing="0">
			<tr>
				<th width="100px" bgcolor="orange">작성자</th>
				<th width="150px"> <%= dto.getWriter() %> </th>
				<th width="100px" bgcolor="orange">작성일</th>
				<th width="100px"> <%= dto.getRegdate() %> </th>
				<th width="100px" bgcolor="orange">조회수</th>				
				<th width="36px"> <%= dto.getCnt() %> </th>
			</tr>
			<tr>
				<th bgcolor="orange">제목</th>
				<td colspan="5"><input type="text" name="title" value="<%= dto.getTitle() %>" width="486px"></td>
			</tr>
			<tr>
				<th bgcolor="orange">내용</th>
				<td colspan="5" height="200px">
				<textarea rows="10" cols="50" name="content"><%= dto.getContent() %></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="6" align="center">
					<input type="submit" value="수정하기">
					<input type="button" value="목록">
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>