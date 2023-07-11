package com.mysite.board;

import java.sql.Date;

public class BoardDTO {
	// Data Transfer Object. ( VO ) : 데이터를 받아서 전송하는 객체.
	// 1. 모든 접근 제어자는 private으로 설정.
	// 2. DataBase 테이블의 컬럼명을 변수명으로 사용.
	// 3. 변수의 자료형도 DataBase 테이블 컬럼의 자료형과 같게 생성.
	// 4. Getter/Setter.		( with rombok )
	// 5. Default Constructor.
	
	// DAO : DataBase Insert,Update,Delete,Select 쿼리를 가지고 있는 객체.
	// Form 에서 전송하는 데이터 ( Client to Server )를 DTO에 담아서 보낸다.
	// Client ===DTO===> Controller ===DTO===> DAO ===> DataBase
	
	// Board Table 각 컬럼에 값을 저장할 DTO 생성
	private int seq ;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int cnt;
	
	
	// Create default Constructor
	public BoardDTO() {}


	// Getter , Setter
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	// toString Overriding.
	@Override
	public String toString() {
		return "BoardDTO [seq="+ seq
				+ ", title=" + title
				+ ", writer=" + writer
				+ ", content=" + content
				+ ", regdate=" + regdate
				+ ", cnt=" + cnt + "]";
	}


}
