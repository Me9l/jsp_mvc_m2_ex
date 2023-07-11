CREATE TABLE board (
    seq NUMBER(5) PRIMARY KEY NOT NULL,
    title VARCHAR2(200) DEFAULT '제목없음' NULL,
    writer VARCHAR2(200) NOT NULL,
    content VARCHAR2(1000) NULL,
    regdate date DEFAULT sysdate NULL,
    cnt NUMBER(5)
);
INSERT INTO board (seq,title,writer,content,regdate,cnt)
VALUES (0,'제목입니다.mvc m2 게시판 생성','admin','mvc m2 내용',DEFAULT,0);
SELECT  * FROM board;
COMMIT;
INSERT INTO board (seq,title,writer,content,regdate,cnt)
VALUES (1,'제목입니다 2.','user01','mvc m2 내용2',DEFAULT,0);
TRUNCATE TABLE board;
-- 

CREATE TABLE users (
    id VARCHAR2(10) PRIMARY KEY NOT NULL,
    pw VARCHAR2(10) NOT NULL,
    name VARCHAR2(20) NOT NULL,
    role VARCHAR2(5)
);
INSERT INTO users
VALUES ('admin','1234','관리자','admin');

INSERT INTO users
VALUES ('user01','1234','일반사용자','user');

SELECT * FROM users;
COMMIT;

TRUNCATE TABLE users;