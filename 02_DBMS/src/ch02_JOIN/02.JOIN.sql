--PART1. 
--1. �̸�, ���ӻ��
SELECT W.ENAME AS WORKER, M.ENAME AS BOSS FROM EMP W, EMP M
    WHERE W.MGR =M.EMPNO; 
    
--2. �̸�, �޿�, ����, ���ӻ��. (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT W.ENAME, W.SAL, W.JOB, NVL(M.ENAME, '����') 
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);

--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME, W.SAL, DNAME, M.ENAME 
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.MGR AND W.DEPTNO = D.DEPTNO; 

--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, LOC, M.ENAME
    FROM EMP W, EMP M, DEPT D 
    WHERE W.MGR = M.MGR(+) AND W.DEPTNO = D.DEPTNO;

--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT W.ENAME, W.SAL, GRADE, DNAME,W.SAL*12+NVL(W.COMM,0) AS ANNUAL_SAL, M.ENAME
    FROM EMP W, EMP M, DEPT D, SALGRADE S 
    WHERE W.MGR  = M.EMPNO AND W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL;

--  PART2

--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ���
SELECT ENAME, JOB, SAL, DNAME 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';

--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT ENAME, DNAME, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL; 

--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME, JOB, DNAME, LOC 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND ENAME LIKE '%L%';

--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO, ENAME, E.DEPTNO, DNAME 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO
    ORDER BY ENAME;

--6. ���, �����, �޿�, �μ����� �˻��϶�. 
    --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, SAL, DEPTNO 
    FROM EMP
    WHERE SAL >= 2000
    ORDER BY SAL DESC; 

--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, JOB, E.SAL, GRADE 
    FROM EMP E, SALGRADE S 
    WHERE E.SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC;
    
--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT W.ENAME, M.ENAME AS BOSS, MM.ENAME AS BOSS2
    FROM EMP W, EMP M, EMP MM 
    WHERE W.MGR = M.EMPNO AND M.MGR = MM.EMPNO;

--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT W.ENAME, M.ENAME AS BOSS, MM.ENAME AS BOSS2
    FROM EMP W, EMP M, EMP MM 
    WHERE W.MGR = M.EMPNO(+) AND M.MGR = MM.EMPNO(+); 