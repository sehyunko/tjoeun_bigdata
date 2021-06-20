-- MySQL 예제에 필요한 personal 테이블과 division 테이블을 생성하고 데이터를 입력하는 코드입니다

drop table if exists personal; -- 사원 테이블
drop table if exists division; -- 부서 테이블(부모) 

create table division( 
	dNo int, -- 부서번호
	dName varchar(20), -- 부서 이름
	phone varchar(20), -- 전화 번호 
    position varchar(20), -- 부서 위치 
    primary key(dNo)); 
    
create table personal (
	pNo int, -- 사번
    pName varchar(20) not null, -- 사원 이름 
    job varchar(20) not null, -- 직책 
    manager int, -- 상사의 사번 
    startDate date, -- 입사일
	pay int, -- 급여 
    bonus int, -- 보너스, 상여금 
    dNo int, 
    primary key(pNo), 
    foreign key(dNo) references division(dNo)); 

-- division 테이블 값 입력
insert into division values (10,'finance', '02-716-1006','신촌');
insert into division values (20,'research', '02-707-1205','용산');
insert into division values (30,'sales', '02-555-2103','강남');
insert into division values (40,'marketing', '02-777-1231','명동');
select * from division;

-- personal 테이블 값 입력
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