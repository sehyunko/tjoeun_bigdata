--8��. SEQUENCE: ���� ��ȣ ������, SEQUENCE�� �������� PRIMARY KEY ��� �뵵 
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
    START WITH 1
    INCREMENT BY 1 
    MAXVALUE 9999 --PRIMARY KEY �ʵ��� Ÿ�Կ� �°� �Է��Ѵ�  
    MINVALUE 1
    NOCACHE -- �ظ��ϸ� �ʼ�. ������ ���ٰ� Ű�� ��츦 ����ؼ� 
    NOCYCLE; -- �̰͵� �ظ��ϸ� �ʼ�. �ߺ��� PRIMARY KEY �����Ǵ°� ��ġ �����Ƿ�;

DROP TABLE FRIEND;
CREATE TABLE FRIEND(
    NUM NUMBER(4) PRIMARY KEY, --������ �̿�
    NAME VARCHAR2(30) NOT NULL, 
    TEL VARCHAR2(20) UNIQUE, 
    ADDRESS VARCHAR2(100),
    LAST_MODIFIED DATE DEFAULT SYSDATE
);

INSERT INTO FRIEND (NUM,NAME,TEL, ADDRESS) --SEQ.NEXTVAL ������ ���� ��� ������
    VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ�浿',NULL,'����� ������'); 
INSERT INTO FRIEND (NUM,NAME,TEL, ADDRESS) --SEQ.NEXTVAL ������ ���� ��� ������
    VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ�浿','010-9999-9999','����� ���빮��');
INSERT INTO FRIEND (NUM,NAME,TEL, ADDRESS) --SEQ.NEXTVAL ������ ���� ��� ������
    VALUES (FRIEND_SEQ.NEXTVAL, '�ű浿','010-8888-8888','����� ��������'); 
    
SELECT * FROM FRIEND; --������ ���� �����Ͱ� ������ ������ ���� �̹� �����Ǿ�����
SELECT FRIEND_SEQ.CURRVAL FROM DUAL; -- ���� ������ �� Ȯ�ο뵵 .CURRVAL
COMMIT;


--������ ����
DROP SEQUENCE TEST_SEQ;
CREATE SEQUENCE TEST_SEQ 
    START WITH 101
    INCREMENT BY 10
    MAXVALUE 999999
    NOCYCLE
    NOCACHE;

SELECT TEST_SEQ.NEXTVAL FROM DUAL;
SELECT TEST_SEQ.CURRVAL FROM DUAL;
