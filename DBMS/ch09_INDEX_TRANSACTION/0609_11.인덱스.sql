-- 11. �ε��� : �� Ű�� �ƴ� �ʵ带 �߽����� ���Ǹ� ���� �ϴ� ��� (SELECT) ��ȸ �ӵ� ����� ���� ��

SELECT * FROM USER_INDEXES; --SCOTT ������ ������ �ε��� 

DROP TABLE EMP01;

CREATE TABLE EMP01
    AS SELECT * FROM EMP;

INSERT INTO EMP01 SELECT * FROM EMP01; -- 1�� ����� (28���� ��) , 2�� ����� (56��) .... 

SELECT COUNT(*) FROM EMP01;

INSERT INTO EMP01 SELECT * FROM EMP01; --12�� ���� (22����)
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111,'HONG',40);
INSERT INTO EMP01 SELECT * FROM EMP01;  --�� �뷫 180���� ���� 

--�ε��� ���� �� ��ȸ �ӵ� : 0.04�� 
SELECT * FROM EMP01 WHERE ENAME = 'HONG';
CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME); --�ε��� ���� 
--�ε��� ���� �� ��ȸ :0.018��
SELECT * FROM EMP01 WHERE ENAME = 'HONG';
SELECT * FROM USER_INDEXES WHERE INDEX_NAME = 'IDX_EMP01_ENAME';
DROP INDEX IDX_EMP01_ENAME;


