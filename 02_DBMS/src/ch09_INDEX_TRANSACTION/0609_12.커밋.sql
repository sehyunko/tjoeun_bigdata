-- 12��. Ʈ����� ��ɾ�(DML ��ɾ�) : COMMIT, ROLLBACK, SAVEPOINT -> ��ҺҰ� 

COMMIT; --���ο� Ʈ����� ���� (INSERT, UPDATE, DELETE �۾� ���� �߰��� ����) 
DROP TABLE DEPT01; 
CREATE TABLE DEPT01 AS SELECT * FROM DEPT; 
DESC DEPT01;

SELECT * FROM DEPT01; -- 10,20,30,40�� �μ�. SELECT ���� ��ȸ�� ���� �� Ʈ������� ���� ���� 
DELETE FROM DEPT01 WHERE DEPTNO = 40; 
SELECT * FROM DEPT01; --10,20,30�� �μ���
ROLLBACK; 
--ROLLBACK ���� ���ο� Ʈ������� ���۵� 
SELECT* FROM DEPT01; --40�� �μ� �ٽ� ���ܳ�. �� 10,20,30,40�� �μ� 
DELETE FROM DEPT01 WHERE DEPTNO = 40;
SELECT * FROM DEPT01;
COMMIT;
--���ο� Ʈ����� ���� 
SELECT * FROM DEPT01; --10,20,30�� �μ� 
DELETE FROM DEPT01 WHERE DEPTNO = 30;
SELECT * FROM DEPT01; --10,20���� ����
SAVEPOINT C1; --C1����: 10��, 20���� ���� 
DELETE FROM DEPT01 WHERE DEPTNO =20; 
SELECT * FROM DEPT01; --10�� �μ� 
SAVEPOINT C2; -- C2 ���� ���� : 10�� �μ��� �ִ� ����
DELETE FROM DEPT01 WHERE DEPTNO= 10;
SELECT * FROM DEPT01; 
ROLLBACK TO C2; -- ROLLBACK; ��� ����, ROLLBACK TO C2 -> C2�������� ���ư� 
COMMIT;