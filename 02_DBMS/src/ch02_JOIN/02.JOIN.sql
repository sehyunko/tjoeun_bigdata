--PART1. 
--1. 이름, 직속상사
SELECT W.ENAME AS WORKER, M.ENAME AS BOSS FROM EMP W, EMP M
    WHERE W.MGR =M.EMPNO; 
    
--2. 이름, 급여, 업무, 직속상사. (상사가 없는 직원까지 전체 직원 다 출력.
    --상사가 없을 시 '없음'으로 출력)
SELECT W.ENAME, W.SAL, W.JOB, NVL(M.ENAME, '없음') 
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);

--4. 이름, 급여, 부서명, 직속상사명
SELECT W.ENAME, W.SAL, DNAME, M.ENAME 
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.MGR AND W.DEPTNO = D.DEPTNO; 

--5. 이름, 급여, 부서코드, 부서명, 근무지, 직속상사명, (상사가 없는 직원까지 전체 직원 다 출력)
SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, LOC, M.ENAME
    FROM EMP W, EMP M, DEPT D 
    WHERE W.MGR = M.MGR(+) AND W.DEPTNO = D.DEPTNO;

--8. 이름, 급여, 등급, 부서명, 연봉, 직속상사명. 연봉=(급여+comm)*12 단 comm이 null이면 0
SELECT W.ENAME, W.SAL, GRADE, DNAME,W.SAL*12+NVL(W.COMM,0) AS ANNUAL_SAL, M.ENAME
    FROM EMP W, EMP M, DEPT D, SALGRADE S 
    WHERE W.MGR  = M.EMPNO AND W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL;

--  PART2

--2. EMP 테이블에서 NEW YORK에서 근무하고 있는 사원에 대하여 이름,업무,급여,부서명을 출력
SELECT ENAME, JOB, SAL, DNAME 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';

--3. EMP 테이블에서 보너스를 받는 사원에 대하여 이름,부서명,위치를 출력
SELECT ENAME, DNAME, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL; 

--4. EMP 테이블에서 이름 중 L자가 있는 사원에 대하여 이름,업무,부서명,위치를 출력
SELECT ENAME, JOB, DNAME, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND ENAME LIKE '%L%';

--5. 사번, 사원명, 부서코드, 부서명을 검색하라. 사원명기준으로 오름차순정열
SELECT EMPNO, ENAME, E.DEPTNO, DNAME 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO
    ORDER BY ENAME;

--6. 사번, 사원명, 급여, 부서명을 검색하라. 
    --단 급여가 2000이상인 사원에 대하여 급여를 기준으로 내림차순으로 정열하시오
SELECT EMPNO, ENAME, SAL, DEPTNO 
    FROM EMP
    WHERE SAL >= 2000
    ORDER BY SAL DESC; 

--8. 사번, 사원명, 업무, 급여, 등급을 검색하시오. 단, 급여기준 내림차순으로 정렬하시오
SELECT EMPNO, ENAME, JOB, E.SAL, GRADE 
    FROM EMP E, SALGRADE S 
    WHERE E.SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC;
    
--10. 사원명, 상사명, 상사의 상사명을 검색하시오
SELECT W.ENAME, M.ENAME AS BOSS, MM.ENAME AS BOSS2
    FROM EMP W, EMP M, EMP MM 
    WHERE W.MGR = M.EMPNO AND M.MGR = MM.EMPNO;

--11. 위의 결과에서 상위 상사가 없는 모든 직원의 이름도 출력되도록 수정하시오
SELECT W.ENAME, M.ENAME AS BOSS, MM.ENAME AS BOSS2
    FROM EMP W, EMP M, EMP MM 
    WHERE W.MGR = M.EMPNO(+) AND M.MGR = MM.EMPNO(+); 