-- 연습문제 

--사번, 이름, 업무, 부서 번호가 담긴 단순뷰를 생성 하시오 
CREATE OR REPLACE VIEW EMPv01 
    AS SELECT EMPNO, ENAME, JOB, DEPTNO
        FROM EMP;
--생성한 단순뷰에 값을 추가 하고, 입력한 값의 직무와 이름을 수정 해보시오 
INSERT INTO EMPv01 VALUES (9000,'HONG','MANAGER', 40); 
UPDATE EMPv01 SET JOB = 'ANALYST', ENAME = 'AMY' WHERE EMPNO = 9000;

-- EMP 테이블과 DEPT 테이블을 EQUI JOIN 하여 하나의 복합뷰를 생성하고 EMP 테이블에서 30번 부서의 사원들에 대한 정보를 입력하시오
--WITH CHECK OPTION을 추가하여 생성하시오 
CREATE OR REPLACE VIEW EMPv02 
    AS SELECT EMPNO, ENAME, E.DEPTNO, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO
    WITH CHECK OPTION; 

-- 10번 부서에 속한 사원의 정보를 입력해보시오 
INSERT INTO EMPv02 VALUES (1011, 'MARK', 10,'ACCOUNTING'); --> CHECK OPTION으로 인해 오류가 생성 

--부서번호, 최소급여, 최대 급여, 부서 평균 급여를 포함한 복합뷰를 생성하시오 
CREATE OR REPLACE VIEW DEPTv1 (DEPTNO,"MINSAL","MAXSAL","AVGSAL")
    AS SELECT E.DEPTNO, MIN(SAL), MAX(SAL),AVG(SAL) 
        FROM EMP E, DEPT D 
        WHERE E.DEPTNO = D.DEPTNO GROUP BY E.DEPTNO; 
SELECT * FROM DEPTv1;