package com.mysite.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mysite.common.JDBCutil;

public class BoardDAO {
	//DAO :DataBase에 직접 접근하는 객체.  DataBase = Repository ( JPA )
		// Insert , Update , Delete , Select 쿼리가 저장되어 직접 DB에 접근.
	
	// 사용할 변수 선언 ( private )
		// Connection , PreparedStatement , ResultSet
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// SQL Query를 상수로 정의 후 각각 필요한 method에 사용.
	
	private final String BOARD_INSERT =
			"INSERT INTO board (seq,title,writer,content) VALUES ((SELECT nvl(max(seq),0)+1 FROM board),?,?,?)";
	private final String BOARD_UPDATE = "UPDATE board SET title=?, content=? WHERE seq=?";
	private final String BOARD_DELETE = "";
	private final String BOARD_GET = "SELECT * FROM board WHERE seq=?";
	private final String ADD_COUNT = "UPDATE board SET cnt=(cnt+1) WHERE seq=?";
	private final String BOARD_LIST = "SELECT * FROM board ORDER BY seq DESC";
	
	// 1. board 테이블에 값 넣기 : Insert
	//BOARD_INSERT = "INSERT INTO board (seq,title,writer,content) VALUES ((SELECT nvl(max(seq),0)+1 FROM board),?,?,?)";
	public void insertBoard( BoardDTO dto ) {
		System.out.println("InsertBoard 기능 처리");
		
		try {
			conn = JDBCutil.getConnection(); // conn 객체 활성화
			pstmt = conn.prepareStatement(BOARD_INSERT); // pstmt 객체 활성화
			// ? 에 들어갈 값 할당.
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			
			// PreparedStatement 객체를 활성화
			pstmt.executeUpdate();
			System.out.println("Insert 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCutil.close(pstmt, conn);
		}
	}
	
	// 2. board 테이블 값 수정 : UPDATE
	// BOARD_UPDATE = "UPDATE board SET title=?, content=? WHERE seq=?";
	public void updateBoard(BoardDTO dto) {
		System.out.println("게시글 내용 수정 진행중..");
		
		try {
			conn = JDBCutil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getSeq());
			
			pstmt.executeUpdate();
			
			System.out.println("update complete.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(pstmt, conn);
		}
	}

	// 3. board 테이블 값 삭제 : DELETE
	
	// 4. 조회 : 상세 페이지 ( GET ) : SELECT ( dto에 담아서 return )
	// BOARD_GET = "SELECT * FROM board WHERE seq=?"
	public BoardDTO getBoard(BoardDTO dto) {
		// 조회수 증가.
		addCnt(dto);
		BoardDTO board = new BoardDTO();
		try {
			System.out.println("Try to connect Database.");
			conn = JDBCutil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, dto.getSeq());
			rs = pstmt.executeQuery();
			
			while( rs.next() ) {
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}

			System.out.println("BOARD_GET : " + board.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(rs, pstmt, conn);
		}
		return board;
	}
	
	public void addCnt(BoardDTO dto) {
		
		try {
			conn = JDBCutil.getConnection();
			pstmt = conn.prepareStatement(ADD_COUNT);
			pstmt.setInt(1, dto.getSeq());
			pstmt.executeUpdate();
			
			System.out.println("count + 1");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(pstmt, conn);			
		}
	}
	
	
	// 5. 모두 조회 : 여러개의 레코드 : SELECT	// BOARD_LIST = "SELECT * FROM board ORDER BY seq DESC";
	public List<BoardDTO> getBoardList(BoardDTO dto){
		System.out.println("getBoardList method has called.");
		List<BoardDTO> boardList = new ArrayList<BoardDTO>(); //try 이전에 선언.

		try {
			conn = JDBCutil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);	// SELECT QUERY INJECTION
			rs = pstmt.executeQuery();					// SELECT QUERY 실행한 결과(record set)를 rs에 저장.
			
			// rs의 값을 dto에 저장.
			while ( rs.next() ) {
				BoardDTO board = new BoardDTO();		// DTO 객체 생성 ( while 안에서 생성 , 밖에서 생성시 heap 주소의 값이 같아서 마지막에 set 된 값 하나만 갖게된다. )

				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegdate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				// boardList 에 DTO 추가
				boardList.add(board);
			}
			System.out.println("boardList has returned successful.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(rs, pstmt, conn);
		}
		return boardList;		// boardList : board TABLE의 각 레코드를 dto에 담아서 저장.
	}
}