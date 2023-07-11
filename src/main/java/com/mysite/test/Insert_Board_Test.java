package com.mysite.test;

import com.mysite.board.BoardDAO;
import com.mysite.board.BoardDTO;

public class Insert_Board_Test {
	public static void main(String[] args) {
		// 1. DTO 객체를 생성해서 setter에 값 주입
		BoardDTO dto = new BoardDTO();
		// dto 객체에 setter를 사용해 필드의 값 입력.
		dto.setTitle("글 제목 입력 5");
		dto.setWriter("user02");
		dto.setContent("글 내용 입력 5");
		// 2. DAO 객체 생성해 insertBoard(dto) 호출시 DB에 Insert
		BoardDAO dao = new BoardDAO();
		
		// dao 객체의 insert메소드 호출시 매개변수로 dto를 던짐
		dao.insertBoard(dto); // db에 값 insert
	}
}
