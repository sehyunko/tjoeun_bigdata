-- �������� 

--���, �̸�, ����, �μ� ��ȣ�� ��� �ܼ��並 ���� �Ͻÿ� 
CREATE OR REPLACE VIEW EMPv01 
    AS SELECT EMPNO, ENAME, JOB, DEPTNO
        FROM EMP;
--������ �ܼ��信 ���� �߰� �ϰ�, �Է��� ���� ������ �̸��� ���� �غ��ÿ� 
INSERT INTO EMPv01 VALUES (9000,'HONG','MANAGER', 40); 
UPDATE EMPv01 SET JOB = 'ANALYST', ENAME = 'AMY' WHERE EMPNO = 9000;

-- EMP ���̺�� DEPT ���̺��� EQUI JOIN �Ͽ� �ϳ��� ���պ並 �����ϰ� EMP ���̺��� 30�� �μ��� ����鿡 ���� ������ �Է��Ͻÿ�
--WITH CHECK OPTION�� �߰��Ͽ� �����Ͻÿ� 
CREATE OR REPLACE VIEW EMPv02 
    AS SELECT EMPNO, ENAME, E.DEPTNO, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO
    WITH CHECK OPTION; 

-- 10�� �μ��� ���� ����� ������ �Է��غ��ÿ� 
INSERT INTO EMPv02 VALUES (1011, 'MARK', 10,'ACCOUNTING'); --> CHECK OPTION���� ���� ������ ���� 

--�μ���ȣ, �ּұ޿�, �ִ� �޿�, �μ� ��� �޿��� ������ ���պ並 �����Ͻÿ� 
CREATE OR REPLACE VIEW DEPTv1 (DEPTNO,"MINSAL","MAXSAL","AVGSAL")
    AS SELECT E.DEPTNO, MIN(SAL), MAX(SAL),AVG(SAL) 
        FROM EMP E, DEPT D 
        WHERE E.DEPTNO = D.DEPTNO GROUP BY E.DEPTNO; 
SELECT * FROM DEPTv1;