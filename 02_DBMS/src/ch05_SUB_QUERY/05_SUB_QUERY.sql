-- �� �� ��������
--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME, SAL,(SELECT MIN(HIREDATE) FROM EMP) AS DATE_HIRED FROM EMP;

-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, (SELECT MIN(SAL) FROM EMP) AS MIN_SAL FROM EMP;

--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME, SAL,HIREDATE, GRADE FROM EMP E, SALGRADE S
    WHERE HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT')
        AND SAL BETWEEN LOSAL AND HISAL;

--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');

--11.  �����ȭ. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME='CLARK')AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = 7698); 


-- ���⼭���ʹ� �����༭�������� �����༭������, ������ �����༭������
-- 14.  �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� ������ ��� ��ȣ,�̸�,�޿�(�� ��� �� ���)
SELECT EMPNO, ENAME, SAL FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%');

-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿�
SELECT ENAME, SAL FROM EMP
    WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');

-- 17. SALES�μ� ����� �̸�, ����
SELECT ENAME, JOB FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

-- 18. ������ �μ� 30�� ���� ���޺��� ���� ����� ��� �ʵ�
SELECT * FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO =30);

-- 19. �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ����
SELECT ENAME, JOB FROM EMP WHERE DEPTNO =10 AND JOB IN (SELECT JOB FROM EMP WHERE DEPTNO=30);

-- 20.  FORD�� ������ ���޵� ���� ����� ��� �ʵ�
SELECT * FROM EMP WHERE (JOB, SAL) = (SELECT JOB, SAL FROM EMP WHERE ENAME ='FORD');

-- 22. SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿�
SELECT ENAME, JOB, SAL
    FROM EMP 
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME IN ('SCOTT','WARD'));

-- 23. CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,����
SELECT ENAME, JOB FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND LOC = (SELECT LOC FROM DEPT WHERE LOC = 'CHICAGO');

-- 24. �μ����� ������ ��� ���޺��� ���� ����� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO GROUP BY DEPTNO); 

-- 26. ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����, �̸�, ���, �μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT DISTINCT MANAGER.JOB, MANAGER.ENAME, MANAGER.EMPNO, MANAGER.DEPTNO FROM EMP WORKER, EMP MANAGER
    WHERE WORKER.MGR(+) = MANAGER.EMPNO AND WORKER.EMPNO IS NOT NULL; 

-- 27.  ���� ����� ���, �̸�, ����, �μ���ȣ
SELECT E2.EMPNO, E2.ENAME, E2.JOB, E2.DEPTNO FROM EMP E1, EMP E2
    WHERE E1.MGR(+) = E2.EMPNO AND E1.MGR IS NULL; 