--������ ���� ������ SAM01 ���̺��� �����Ͻÿ� 

-- EMPNO(���) - NUMBER(4) 
-- ENAME(�̸�) - VARCHAR2(10)
-- JOB(��å) - VARCHAR2(9) 
-- SAL(�޿�) - NUMBER(7,2)

-- EMP01�̶�� ���̺� EMP���̺��� 10�� �μ� �Ҽ� ����� ������ �߰��Ѵ� 
-- EMP01 ��� ����� �μ���ȣ�� 30������ �����Ѵ� 
-- EMP01 ���̺� �� ��� ������ �޿��� 10% �λ��Ų�� 
-- EMP01 �޿��� 3000�̻��� ����� �޿��� 10% �� �λ� ��Ų�� 
-- EMP01 SCOTT�� �μ���ȣ�� 20������, ������ MANAGER�� �Ѳ����� �����Ѵ� 
-- EMP01 ���̺� �μ����� SALES�� ����� ��� �����Ͻÿ� 
-- SAM01���̺� �� JOB�� NULL�� ����� ���� 
-- SAM01���̺� �� ENAME�� ORANGE�� ����� ����

--�̹� �ִ� EMP01, SAM01 ���̺� ����
DROP TABLE EMP01; 
DROP TABLE SAM01; 

--EMP01 ���̺� ���� �� �� �Է�
CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10), 
    JOB VARCHAR2(9), 
    SAL NUMBER(7,2),
    DEPTNO NUMBER(2)
);

--EMP01�̶�� ���̺� EMP���̺��� 10�� �μ� �Ҽ� ����� ������ �߰��Ѵ� 
INSERT INTO EMP01 SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP;


-- EMP01 ��� ����� �μ���ȣ�� 30������ �����Ѵ� 
UPDATE EMP01 SET DEPTNO =30; 

-- EMP01 ���̺� �� ��� ������ �޿��� 10% �λ��Ų�� 
UPDATE EMP01 SET SAL= SAL*1.1;

-- EMP01 �޿��� 3000�̻��� ����� �޿��� 10% �� �λ� ��Ų�� 
UPDATE EMP01 SET SAL = SAL*1.1 WHERE SAL >= 3000; 

--EMP01 ���̺��� �ٹ����� DALLAS�� ����� ������ 1000�λ� �Ѵ�
UPDATE EMP01 SET SAL = SAL+1000 
    WHERE DEPTNO = (SELECT E.DEPTNO 
                        FROM EMP01 E, DEPT D 
                        WHERE E.DEPTNO = D.DEPTNO AND DNAME ='DALLAS');

--SCOTT ����� �μ���ȣ�� 20������, ������ MANAGER�� �Ѳ����� �����Ѵ�
UPDATE EMP01 SET DEPTNO = 20, JOB = 'MANAGER' WHERE ENAME = 'SCOTT';

--�μ����� SALES�� ����� ��� ���� 
DELETE FROM EMP01 WHERE DEPTNO IN (SELECT E.DEPTNO FROM EMP01 E, DEPT D WHERE DNAME ='SALES');

--�̸��� FORD�� ����� ����
DELETE FROM EMP01 WHERE ENAME = 'FORD';


-- SAM01 ���̺� ���� �� �� �Է�
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

-- SAM01���̺� �� JOB�� NULL�� ����� ���� 
DELETE FROM SAM01 WHERE JOB IS NULL;

-- SAM01���̺� �� ENAME�� ORANGE�� ����� ����
DELETE FROM SAM01 WHERE ENAME = 'ORANGE';