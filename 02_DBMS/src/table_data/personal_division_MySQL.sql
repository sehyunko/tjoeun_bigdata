-- MySQL ������ �ʿ��� personal ���̺�� division ���̺��� �����ϰ� �����͸� �Է��ϴ� �ڵ��Դϴ�

drop table if exists personal; -- ��� ���̺�
drop table if exists division; -- �μ� ���̺�(�θ�) 

create table division( 
	dNo int, -- �μ���ȣ
	dName varchar(20), -- �μ� �̸�
	phone varchar(20), -- ��ȭ ��ȣ 
    position varchar(20), -- �μ� ��ġ 
    primary key(dNo)); 
    
create table personal (
	pNo int, -- ���
    pName varchar(20) not null, -- ��� �̸� 
    job varchar(20) not null, -- ��å 
    manager int, -- ����� ��� 
    startDate date, -- �Ի���
	pay int, -- �޿� 
    bonus int, -- ���ʽ�, �󿩱� 
    dNo int, 
    primary key(pNo), 
    foreign key(dNo) references division(dNo)); 

-- division ���̺� �� �Է�
insert into division values (10,'finance', '02-716-1006','����');
insert into division values (20,'research', '02-707-1205','���');
insert into division values (30,'sales', '02-555-2103','����');
insert into division values (40,'marketing', '02-777-1231','��');
select * from division;

-- personal ���̺� �� �Է�
insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
select * from personal;

commit;