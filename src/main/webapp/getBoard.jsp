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
	<h2> 상세 보기 </h2>
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
				<td colspan="5"> <%= dto.getTitle() %> </td>
			</tr>
			<tr>
				<th bgcolor="orange">내용</th>
				<td colspan="5" height="200px"> <%= dto.getContent() %></td>
			</tr>
			<tr>
				<td colspan="6" align="end">
					<a href="getBoardList.do"> 목록 </a> |
					<a href="updateBoard.jsp"> 수정 </a> |
					<a href="deleteBoard.do?seq=<%= dto.getSeq() %>"> 삭제 </a>
				</td>
			</tr>
		<% session.removeAttribute("boardList"); %>
		</table>
	</div>
</body>
</html>