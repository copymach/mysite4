-- rboard 계층형 게시판 만들기

--테이블 삭제 초기화
drop table rboard;
--테이블 내용만 초기화 
TRUNCATE TABLE rboard;
--id 번호 자동생성 꼬일때 초기화 (리셋)
drop SEQUENCE seq_rboard_no; 
drop SEQUENCE seq_rboard_group_no;

--테이블의 모든 정보
select * from rboard;

--테이블 삭제하기
drop table rboard; 

--계층형 게시판 rboard 테이블 만들기
create table    rboard (
                no number(10), --글번호                
                title varchar2(500), --NOT NULL 제목
                content varchar2(4000), --내용
                hit number (10), --조회수 30개도 에러난다 
                reg_date date NOT NULL, --등록일
                group_no number (10), --그룹번호
                order_no number (10), --그룹내 글순서
                depth number (10), --깊이
                primary key (no), --프라이머리 키 지정
                user_no number(10) NOT NULL, --회원식별번호 포린키
CONSTRAINT rboard_fk FOREIGN KEY (user_no) REFERENCES users(no)
);

-- rboard no 번호 자동생성을 위한 시퀀스 sequence
create sequence seq_rboard_no
increment by 1
START WITH 1
nocache
;

-- rboard group_no 번호 자동생성을 위한 시퀀스 sequence
create sequence seq_rboard_group_no
increment by 1
START WITH 1
nocache
;


    
--시퀀스 조회 (서버내 모든 대상)
SELECT * FROM USER_SEQUENCES;
            
--게시판 정보 입력해보기 식별번호(no시퀀스), 제목, 내용, 조회수, 등록일, 그룹번호, 그룹순서, 깊이, 유저번호
--새글의 경우 group_no 는 글번호와 동일, order_no는 1, depth는 0
INSERT INTO rboard 
VALUES (seq_rboard_no.nextval, '와봤습니다', '구경왔습니다' , 13 , sysdate, seq_rboard_group_no.nextval, 1, 0, 5);

INSERT INTO rboard 
VALUES (seq_rboard_no.nextval, '맛과 가격을 잡은 가성비 귤', '타이벡 감귤 사면 됨' , 9 , sysdate, seq_rboard_group_no.nextval, 1, 0, 6);

INSERT INTO rboard 
VALUES (seq_rboard_no.nextval, '민초파 여기 모여라', '주말에 베라 ㄱㄱ' , 0 , sysdate, seq_rboard_group_no.nextval, 1, 0, 6);

INSERT INTO rboard 
VALUES (seq_rboard_no.nextval, '치킨 땡긴다', '뭐시켜먹을까' , 0 , sysdate, seq_rboard_group_no.nextval, 1, 0, 7);

INSERT INTO rboard 
VALUES (seq_rboard_no.nextval, '원글 제목1', '원글 내용1' , 0 , sysdate, seq_rboard_group_no.nextval, 1, 0, 7);


--댓글 정보 no시퀀스, 제목, 내용, 조회수, 등록일, 그룹번호, 그룹순서, 깊이, 유저번호
--댓글의 경우 group_no 는 글번호와 동일, order_no는 +1, depth는 +1
INSERT INTO rboard 
VALUES (seq_rboard_no.nextval, '댓글제목', '댓글내용' , 0 , sysdate
        , 10
        , order_no+1 
        , depth+1
        , 5)
;

INSERT INTO rboard 
VALUES (seq_rboard_no.nextval, '댓글제목2', '댓글내용2' , 0 , sysdate, 5, order_no+1, depth+1, 6);

INSERT INTO rboard 
VALUES (seq_rboard_no.nextval, '댓글제목3', '댓글내용3' , 0 , sysdate, 5, +1, +1, 7);


insert into rboard value (
(SELECT ISNULL(MAX(order_no),0) + 1 FROM rboard)
, (SELECT NVL(MAX(depth), 0) + 1 FROM rboard)
)
where no= 5
;

select * from rboard;

--NVL(MAX(depth),0)+1
--SELECT TO_NUMBER(NVL(MAX(order_no), '0')) + 1 FROM rboard;

--NVL(MAX(Column2),'0')+1

--Insert rboard
--into Column1, Column2
--values("Column1에 들어갈 값", "NVL(MAX(Column2),'0')+1 );



-- 수정기능 (id n번)의 데이터를 변경
UPDATE rboard
SET title = '동해물과백두산이',
    content = '마르고 닳도록'
WHERE no = 6
and user_no = 16
;


-- 테이블에서 (no번) 데이터를 삭제해 보세요
TRUNCATE TABLE rboard WHERE no = 1;

DELETE FROM rboard WHERE no = 2 ;


--커밋 
commit;

--롤백
rollback;

-- selectOne 게시물 하나만 가져오기
select  bd.no bno
        ,title
        ,content
        ,hit
        ,to_char(reg_date, 'yy-mm-dd hh24:mi') reg_date 
        ,user_no uno
        ,ur.id id
        ,ur.password password
        ,ur.name name
        ,bd.group_no
        ,bd.order_no
        ,bd.depth
from rboard bd, users ur
where bd.user_no = ur.no
and bd.no = 2;

--hit 카운터
UPDATE rboard 
set HIT = NVL(HIT, 0) + 1
WHERE rboard.no = 9;
    

-- 게시물 1개 삭제
DELETE FROM rboard
WHERE user_no = 16 
and no = 3
;


		
-- 게시물 1개 불러오기
select  bd.no bno
        ,title
        ,content
        ,hit
        ,to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') reg_date 
        ,user_no uno
        ,ur.id id
        ,ur.password password
        ,ur.name user_name         
from board bd, users ur
where bd.user_no = ur.no
and bd.no = 9;



--모든 정보 출력 카티젼
select *
from rboard bd, users us
where bd.user_no = us.no;

select * from rboard;
select * from users;


--게시판 목록용
select  bd.no bno
        ,title
        ,content
        ,hit
        ,to_char(reg_date, 'yy-mm-dd hh24:mi') reg_date
        ,user_no uno
        ,ur.id id
        ,ur.password password
        ,ur.name name
        ,bd.group_no
        ,bd.order_no
        ,bd.depth
from rboard bd, users ur
where bd.user_no = ur.no
order by reg_date desc, group_no DESC, order_no ASC
;

--게시판 내용
select  bd.no bno
        ,title
        ,content
        ,hit
        ,to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') regDate 
        ,user_no uno
        ,ur.id id
        ,ur.password password
        ,ur.name name
        ,bd.group_no
        ,bd.order_no
        ,bd.depth
from rboard bd, users ur
where bd.user_no = ur.no
and bd.no = 9;
;
-- hit 티베로 조회수 증가 
--혹시 필드가 varchar 타입인 경우 TO_NUMBER로 캐스팅 하고
--혹시 NOT NULL 허용일지도 모름으로 NVL로 NULL값을 0으로 치환
UPDATE rboard 
set HIT = NVL(HIT, 0) + 1
WHERE rboard.no = 9;

            

--게시물 수정 업데이트
UPDATE rboard 
set     title = '수정한 제목',
        content = '수정한 내용'
WHERE rboard.no = 9;


select  bd.no bno
	        ,title
	        ,content
	        ,hit
	        ,to_char(reg_date, 'yy-mm-dd hh24:mi') reg_date 
	        ,user_no uno
	        ,ur.id id
	        ,ur.password password
	        ,ur.name user_name
	        ,bd.group_no
	        ,bd.order_no
	        ,bd.depth
from rboard bd, users ur
where bd.user_no = ur.no
order by reg_date desc;
        
            
select * from rboard;    

