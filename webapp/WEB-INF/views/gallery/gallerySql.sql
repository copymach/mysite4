/* webdb gallery 테이블 만들기 */


--테이블 상태 확인
select * from gallery;

--테이블 삭제 초기화
drop table gallery;

--id 번호 자동생성 꼬일때 초기화 (리셋)
drop SEQUENCE seq_gallery_no; 

-- 모든 정보 보기 (카티전)
SELECT * FROM gallery
;

--시퀀스 조회
SELECT * FROM USER_SEQUENCES;

--갤러리 gallery 테이블 만들기
create table    gallery (
                no number(10), --글번호                
                content varchar2(1000), --코멘트
                filePath varchar2(500), --파일경로
                orgName varchar2(200), --원본파일명
                saveName varchar2(500), --저장파일명
                fileSize number (10), -- 파일사이즈                
                reg_date date NOT NULL, --등록일                
                primary key (no), --프라이머리 키 지정
                user_no number(10) NOT NULL, --회원식별번호 포린키
CONSTRAINT gallery_fk FOREIGN KEY (user_no) REFERENCES users(no)
);

-- 저자 id번호 자동생성을 위한 시퀀스 sequence
create sequence seq_gallery_no
increment by 1
START WITH 1
nocache
;

select * from gallery;

--갤러리 정보 입력 (글no 코멘트 파일경로 원본파일명 저장파일명 파일사이즈 등록일 작성자no)
INSERT INTO gallery VALUES (
seq_gallery_no.nextval, '그림등록1', 'C:\javaStudy\upload\', '원본파일1.jpg', '저장파일1.jpg', '1000', sysdate, 3)
;



-- 테이블에서 (id n번) 데이터를 삭제해 보세요
TRUNCATE TABLE gallery WHERE no = 1;

DELETE FROM gallery WHERE no = 1;


--커밋 
commit;

--롤백
rollback;


--갤러리 목록용
select  gl.no bno
        ,content
        ,filePath
        ,orgName
        ,saveName
        ,fileSize
        ,to_char(reg_date, 'yy-mm-dd hh24:mi') reg_date
        ,ur.no uno
        ,ur.id id
        ,ur.name name
from gallery gl, users ur
where ur.no = gl.user_no
order by reg_date desc
;

--모든 정보 출력 카티션
select *
from gallery gl, users ur
where ur.no = gl.user_no
;

DELETE FROM gallery
WHERE	user_no = 3
and		no = 2
;
rollback;