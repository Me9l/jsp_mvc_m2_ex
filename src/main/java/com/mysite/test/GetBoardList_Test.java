package com.mysite.test;

import java.util.ArrayList;
import java.util.List;

import com.mysite.board.BoardDAO;
import com.mysite.board.BoardDTO;

public class GetBoardList_Test {
	public static void main(String[] args) {
		
		// 1. DTO 객체 생성
		BoardDTO dto = new BoardDTO();

		// 2. DAO 객체 생성
		BoardDAO dao = new BoardDAO();
		
		// 3. 메소드 호출시 리턴 받을 리스트 변수 : List<BoardDTO>
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		// boardList = DB의 board 테이블의 레코드를 dto에 저장 후 List에 추가한 값 저장. 
		boardList = dao.getBoardList(dto);
		
		// boardList 값 확인
//		System.out.println(boardList);
		
		// ArrayList 에 저장된 값 출력.
//		for (int i = 0; i < boardList.size(); i++) {
//			System.out.println(boardList.get(i));
//		}
		
		for (BoardDTO boardDTO : boardList) {
			System.out.println(boardDTO);
		}
		
	}
}
