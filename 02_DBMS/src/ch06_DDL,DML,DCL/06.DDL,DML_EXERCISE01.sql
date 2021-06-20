--아래 구조를 만족하는 테이블을 생성해보기 
--      Name        Null?           Type
--      ID         NOT NULL        NUMBER(4)
--      NAME                       VARCHAR2(10)
--      USERID                     VARCHAR2(30)
--      SALARY                     NUMBER(10,2)
-- 
-- 입력한 자료를 영구적으로 데이터베이스에 등록하시오 
-- ID가 3번인 사람의 급여를 65,000.00으로 갱신하고 영구적으로 데이터 베이스에 반영하시오 
-- 이름이 Ford인 사원을 영구제명 하시오 (데이터에서 삭제 하시오) 
--급여가 15,000이하인 사람의 급여를 15,000으로 변경하시오 
-- 위 작성한 테이블을 삭제 하시오 

--기존에 있던 MY_DATA 삭제
DROP MY_DATA; 

--MY_DATA 생성
CREATE TABLE MY_DATA( 
    ID NUMBER(4) PRIMARY KEY, 
    NAME    VARCHAR2(10), 
    USERID  VARCHAR2(30),
    SALARY NUMBER(10,2)
); 

--MY_DATA에 값 입력 
INSERT INTO MY_DATA VALUES(1,'Scott','sscott',10000.00); 
INSERT INTO MY_DATA VALUES(2,'Ford','fford',13000.00);
INSERT INTO MY_DATA VALUES(3,'Patel','ppatel',33000.00);
INSERT INTO MY_DATA VALUES(4,'Report','rreport',23500.00);
INSERT INTO MY_DATA VALUES(5,'Good','ggood',44450.00);
COMMIT;

--입력한 값 확인
SELECT * FROM MY_DATA;

-- ID 3번 인물 급여 65000으로 변경 
UPDATE MY_DATA SET SALARY = 65000 WHERE ID =3;

--Ford 라는 사람의 데이터 삭제 
DELETE FROM MY_DATA WHERE NAME = 'Ford';

--급여가 15000 이하인 사람의 급여 15000으로 
UPDATE MY_DATA SET SALARY = 15000 WHERE SALARY <= 15000;

--테이블 삭제
DROP TABLE MY_DATA; 