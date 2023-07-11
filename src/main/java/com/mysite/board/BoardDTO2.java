package com.mysite.board;

import java.sql.Date;

import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
import lombok.ToString;

@Data					// getter,setter,noargs,toString, hashcode,equals 등등 한번에 생성.  
//@NoArgsConstructor
//@Getter @Setter
@ToString
public class BoardDTO2 {
	
	private int seq ;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int cnt;
	
}
