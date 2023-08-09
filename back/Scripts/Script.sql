SELECT * FROM "MEMBER";
DESC MEMBER;
SELECT * FROM "WRITER";
SELECT USER FROM dual;

ALTER CREATE 

SELECT p.maintitle, p.content, p.maintitleimg 
FROM post p JOIN member m ON (p.usernum = m.id)
WHERE loginid ='asdasd';

SELECT m.name, m.intro, m.profile
FROM writer w JOIN member m ON (w.writerid = m.id)
WHERE loginId='suwan';	--작가의 멤버아이디 
--작가테이블에 작가의 아이디를 넣어야함

SELECT p.maintitle, p.content, p.maintitleImg, m.name
FROM post p, writer w, member m
WHERE w.writerid = 1;

--작가의 로그인 아이디를 생성하기- 회원의 로그인 아이디를 참조해올경우 로그인한 사람의 아이디로 자기글이 노출됨
--writerloginid- fk로 member의 loginid참고
SELECT m.loginid FROM MEMBER m JOIN writer w WHERE M.ID = w.WRITERID; 

-- 구독테이블로 변경
