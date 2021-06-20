--다음과 같은 구조로 SAM01 테이블을 생성하시오 

-- EMPNO(사번) - NUMBER(4) 
-- ENAME(이름) - VARCHAR2(10)
-- JOB(직책) - VARCHAR2(9) 
-- SAL(급여) - NUMBER(7,2)

-- EMP01이라는 테이블에 EMP테이블의 10번 부서 소속 사원의 정보를 추가한다 
-- EMP01 모든 사원의 부서번호를 30번으로 수정한다 
-- EMP01 테이블 내 모든 직원의 급여를 10% 인상시킨다 
-- EMP01 급여가 3000이상인 사원만 급여를 10% 더 인상 시킨다 
-- EMP01 SCOTT의 부서번호는 20번으로, 직급은 MANAGER로 한꺼번에 수정한다 
-- EMP01 테이블 부서명이 SALES인 사원을 모두 삭제하시오 
-- SAM01테이블 내 JOB이 NULL인 사원을 삭제 
-- SAM01테이블 내 ENAME이 ORANGE인 사람을 삭제

--이미 있는 EMP01, SAM01 테이블 삭제
DROP TABLE EMP01; 
DROP TABLE SAM01; 

--EMP01 테이블 생성 및 값 입력
CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10), 
    JOB VARCHAR2(9), 
    SAL NUMBER(7,2),
    DEPTNO NUMBER(2)
);

--EMP01이라는 테이블에 EMP테이블의 10번 부서 소속 사원의 정보를 추가한다 
INSERT INTO EMP01 SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP;


-- EMP01 모든 사원의 부서번호를 30번으로 수정한다 
UPDATE EMP01 SET DEPTNO =30; 

-- EMP01 테이블 내 모든 직원의 급여를 10% 인상시킨다 
UPDATE EMP01 SET SAL= SAL*1.1;

-- EMP01 급여가 3000이상인 사원만 급여를 10% 더 인상 시킨다 
UPDATE EMP01 SET SAL = SAL*1.1 WHERE SAL >= 3000; 

--EMP01 테이블에서 근무지가 DALLAS인 사람의 연봉을 1000인상 한다
UPDATE EMP01 SET SAL = SAL+1000 
    WHERE DEPTNO = (SELECT E.DEPTNO 
                        FROM EMP01 E, DEPT D 
                        WHERE E.DEPTNO = D.DEPTNO AND DNAME ='DALLAS');

--SCOTT 사원의 부서번호를 20번으로, 직급은 MANAGER로 한꺼번에 수정한다
UPDATE EMP01 SET DEPTNO = 20, JOB = 'MANAGER' WHERE ENAME = 'SCOTT';

--부서명이 SALES인 사원을 모두 삭제 
DELETE FROM EMP01 WHERE DEPTNO IN (SELECT E.DEPTNO FROM EMP01 E, DEPT D WHERE DNAME ='SALES');

--이름이 FORD인 사원을 삭제
DELETE FROM EMP01 WHERE ENAME = 'FORD';


-- SAM01 테이블 생성 및 값 입력
CREATE TABLE SAM01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10), 
    JOB VARCHAR2(9), 
    SAL NUMBER(7,2)
); 

INSERT INTO SAM01 VALUES (1000, 'APPLE', 'POLICE',10000); 
INSERT INTO SAM01 VALUES (1010, 'BANANA', 'NURSE',15000); 
INSERT INTO SAM01 VALUES (1020, 'ORANGE', 'DOCTOR',25000); 
INSERT INTO SAM01 VALUES (1030, 'VERY', NULL,25000); 
INSERT INTO SAM01 VALUES (1040, 'CAT', 'NULL',2000); 
INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL 
                        FROM EMP
                        WHERE ENAME IN ('CLARK','KING','MILLER');

-- SAM01테이블 내 JOB이 NULL인 사원을 삭제 
DELETE FROM SAM01 WHERE JOB IS NULL;

-- SAM01테이블 내 ENAME이 ORANGE인 사람을 삭제
DELETE FROM SAM01 WHERE ENAME = 'ORANGE';