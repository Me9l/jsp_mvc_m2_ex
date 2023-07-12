package com.mysite.test;

import com.mysite.board.BoardDAO;
import com.mysite.board.BoardDTO;

public class UpdateBoard_test {

	public static void main(String[] args) {
		// 1. dto 에 값 할당
		BoardDTO dto = new BoardDTO();
		dto.setTitle("TEST_TITLE");
		dto.setContent("TEST_CONTENT");
		dto.setSeq(10);
		
		BoardDAO dao = new BoardDAO();
		dao.updateBoard(dto);
		
		System.out.println("Update success.");
		
	}

}
