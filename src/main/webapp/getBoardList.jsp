<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@ page import="com.mysite.board.BoardDTO" %>
<%
	// Session 값 추출.
	List<BoardDTO> boardList = new ArrayList<BoardDTO>();
	boardList = (List)session.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> getBoardList </title>
<style>
	.boardList{
		width : 600px;
		margin : 0 auto;
	}
</style>
</head>
<body>
	<div class="boardList">
	<h3> 글목록 </h3>
	<table border="1px" cellpadding="0" cellspacing="0" width="700px">
		<tr>
			<th bgcolor="orange" width="48px">번호</th>
			<th bgcolor="orange" width="200px">제목</th>
			<th bgcolor="orange" width="100px">작성자</th>
			<th bgcolor="orange" width="100px">작성일</th>
			<th bgcolor="orange" width="48px">조회수</th>
		</tr>
		
		<!-- DB에서 불러온 값 출력 -->
		<% for (BoardDTO dto : boardList) {%>
		<tr>
			<td><%= dto.getSeq() %></td>
			<td><%= dto.getTitle() %></td>
			<td><%= dto.getWriter() %></td>
			<td><%= dto.getRegdate() %></td>
			<td><%= dto.getCnt() %></td>
		</tr>
		<% }
			session.removeAttribute("boardList");
		%>
	</table>
	<br/><br/>
	<a href="insertBoard.jsp"> 새 글 등록 </a>
	</div>
</body>
</html>