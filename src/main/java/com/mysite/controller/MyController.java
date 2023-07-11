package com.mysite.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysite.board.BoardDAO;
import com.mysite.board.BoardDTO;
import com.mysite.users.UsersDAO;
import com.mysite.users.UsersDTO;

/**
 * Servlet implementation class MyController
 */
//@WebServlet("/MyController")	// << Annotation으로 요청 처리
/*
 Controller : Client 의 요청을 처리 ( get, post )
 		- doGet(){} : Client 에서 보내는 get 요청을 처리하는 method. <form method="get" action="aaa.jsp"> , <a href="aaa.jsp">
 		- doPst(){} : Client 에서 보내는 post 요청을 처리하는 method. <form method="post" action="bbb.jsp">
 		
 		controller 요청을 처리하는 방법
 			web.xml : 클라이언트의 요청에 대한 controller를 지정.
 			@WebServlet : annotation으로 요청 처리.
 		
*/

public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: (MyController) ").append(request.getContextPath());
		// client 에서 get 방식으로 넘어오는 요청 처리를 doPost에서 한꺼번에 처리하도록 던짐.
		doPost (request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		// client 에서 Get/ Post 를 한번에 처리.
		
		// 1. client에서 보낸 요청에서 path 추출. 
//		String url = request.getRealPath(getServletName());	// system 내부의 물리적 절대경로.
//		System.out.println("url from client : " + url);
		
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();	// 
//		System.out.println("uri from client : " + uri);
		
		String path = uri.substring(uri.lastIndexOf("/"));
//		System.out.println("uri.substring(uri.lastIndexOf(\"/\")) : " + path);
		
		// 2. client의 요청 정보에 따라 분기 처리.
		if ( path.equals("/login.do")) {
			System.out.println("request login.do.");
			
		} else if (path.equals("/logout.do")) {
			System.out.println("request logout.do");
			
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("request insertBoard.do");
			// 게시판에서 넘어온 값을 DB에 저장
			
			// 1. client form 에서 오는 변수의 값을 새로운 변수에 할당.
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. BoardDTO 객체를 생성해 Setter를 이용해 값 주입.
			BoardDTO dto = new BoardDTO();
			dto.setTitle(title);
			dto.setWriter(writer);
			dto.setContent(content);
			
			// 3. DAO객체 생성후 insertBoard(dto) 실행. dto를 dao를 통해 전달
			BoardDAO dao = new BoardDAO();
			dao.insertBoard(dto);
						
			// 4. businessLogic 처리 후 view 페이지로 이동
			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/getBoard.do")) {
			System.out.println("request getBoard.do");
			
		} else if (path.equals("/getBoardList.do")) {
			System.out.println("request getBoardList.do");
			
			// 1. DTO 객체 생성 ( DAO 의 getBoardList(dto)에 넣을 파라미터 )
			BoardDTO dto = new BoardDTO();
			// 2. DAO 객체 생성
			BoardDAO dao = new BoardDAO();
			// 3. DAO가 DB에 접근해서 DTO에 저장해온 값을 boardList에 저장.
			List<BoardDTO> boardList = new ArrayList<BoardDTO>();
			boardList = dao.getBoardList(dto);
			// return 받은 boardList를 client View에게 전달.
			// ( Session 에 List 저장후 전달 )
			// Session : 접속한 client에 고유하게 부여된 식별자. 서버 메모리에 할당.
			// request로 현재 세션 정보를 가져와 session에 저장.
			HttpSession session = request.getSession();
			
			// 세션에 boardList 추가.
			session.setAttribute("boardList", boardList);
			// 클라이언트 뷰 페이지 이동.
			response.sendRedirect("getBoardList.jsp");
			
		}else if (path.equals("/insertUsers.do")) {
			//Users 테이블에 값 insert.
			System.out.println("request insertUsers.do");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			
			UsersDTO dto = new UsersDTO();
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			
			UsersDAO dao = new UsersDAO();
			dao.insertUsers(dto);
			
			response.sendRedirect("getUsersList.do");
		}else if (path.equals("/getUsersList.do")) {
			// Users 테이블 값 select.
			System.out.println("request getUsersList.do");
			UsersDTO dto = new UsersDTO();
			UsersDAO dao = new UsersDAO();
			
			// usersList를 담을 List 생성
			List<UsersDTO> usersList = new ArrayList<>();
			usersList = dao.getUsersList(dto);
			
			// 현재 세션정보를 가져와서 session 에 저장.
			HttpSession session = request.getSession();
			// session 에 usersList 정보 추가.
			session.setAttribute("usersList", usersList);
			// client view 이동
			response.sendRedirect("getUsersList.jsp");
			
			
		}
		
		
	}
}
