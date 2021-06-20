--�Ʒ� ������ �����ϴ� ���̺��� �����غ��� 
--      Name        Null?           Type
--      ID         NOT NULL        NUMBER(4)
--      NAME                       VARCHAR2(10)
--      USERID                     VARCHAR2(30)
--      SALARY                     NUMBER(10,2)
-- 
-- �Է��� �ڷḦ ���������� �����ͺ��̽��� ����Ͻÿ� 
-- ID�� 3���� ����� �޿��� 65,000.00���� �����ϰ� ���������� ������ ���̽��� �ݿ��Ͻÿ� 
-- �̸��� Ford�� ����� �������� �Ͻÿ� (�����Ϳ��� ���� �Ͻÿ�) 
--�޿��� 15,000������ ����� �޿��� 15,000���� �����Ͻÿ� 
-- �� �ۼ��� ���̺��� ���� �Ͻÿ� 

--������ �ִ� MY_DATA ����
DROP MY_DATA; 

--MY_DATA ����
CREATE TABLE MY_DATA( 
    ID NUMBER(4) PRIMARY KEY, 
    NAME    VARCHAR2(10), 
    USERID  VARCHAR2(30),
    SALARY NUMBER(10,2)
); 

--MY_DATA�� �� �Է� 
INSERT INTO MY_DATA VALUES(1,'Scott','sscott',10000.00); 
INSERT INTO MY_DATA VALUES(2,'Ford','fford',13000.00);
INSERT INTO MY_DATA VALUES(3,'Patel','ppatel',33000.00);
INSERT INTO MY_DATA VALUES(4,'Report','rreport',23500.00);
INSERT INTO MY_DATA VALUES(5,'Good','ggood',44450.00);
COMMIT;

--�Է��� �� Ȯ��
SELECT * FROM MY_DATA;

-- ID 3�� �ι� �޿� 65000���� ���� 
UPDATE MY_DATA SET SALARY = 65000 WHERE ID =3;

--Ford ��� ����� ������ ���� 
DELETE FROM MY_DATA WHERE NAME = 'Ford';

--�޿��� 15000 ������ ����� �޿� 15000���� 
UPDATE MY_DATA SET SALARY = 15000 WHERE SALARY <= 15000;

--���̺� ����
DROP TABLE MY_DATA; 