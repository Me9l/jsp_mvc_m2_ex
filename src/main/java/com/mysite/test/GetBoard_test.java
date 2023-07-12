package com.mysite.test;

import com.mysite.board.BoardDAO;
import com.mysite.board.BoardDTO;

public class GetBoard_test {
	public static void main(String[] args) {
		
		// 1. dto 에 seq 할당
		BoardDTO dto = new BoardDTO();
		dto.setSeq(10);
		// 2. dao method 호출
		BoardDAO dao = new BoardDAO();
		
		System.out.println(dao.getBoard(dto));
	}
}
