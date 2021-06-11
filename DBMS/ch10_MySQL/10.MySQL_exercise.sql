-- 연습문제 

-- 1. 사번, 이름, 급여를 출력
select pNo, pName, pay from personal;

-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * from personal 
	where pay between 2000 and 5000;

-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pNo, pName, dNo from personal 
	where dNo in (10,20); 

-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pNo, pName, pay from personal 
	where bonus is null
    order by pay desc; 

-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pNo, pName, dNo, pay from personal 
	order by dNo, pay desc;

-- 6. 사번, 이름, 부서명
select pNo, pName, dName from personal p, division d
	where p.dNo = d.dNo;
    
-- 7. 사번, 이름, 상사이름
select w.pNo, w.pName, m.pName "manager" from personal w, personal m
	where w.manager = m.pNo;

-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
select w.pNo, w.pName "worker", ifnull(m.pName,'no manager') "manager" 
	from personal w
    left join personal m on w.manager = m.pNo;

select w.pNo, w.pName "worker", if(m.pName is null,'no manager',m.pName) "manager" 
	from personal w
    left join personal m on w.manager = m.pNo;

-- 9. 이름이 s로 시작하는 사원 이름
select pName from personal 
	where pName like 's%';

-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pNo, w.pName, w.pay, dName, m.pName "manager"
	from personal w, personal m, division d
    where w.pNo = m.pNo and w.dNo = d.dNo;

-- 11. 부서코드, 급여합계, 최대급여
select distinct dNo, sum(pay), max(pay)
	from personal
    group by dNo;

-- 12. 부서명, 급여평균, 인원수
select dName, avg(pay), count(*)
	from personal p,division d
		where p.dNo = d.dNo
        group by dName ;
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dNo, sum(pay), count(*)
	from personal
    group by dNo
    having count(*) >= 4;
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pNo, pName, pay
	from personal 
    where pay = (select max(pay) from personal);

-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pName, pay, dNo 
	from personal 
    where pay > (select avg(pay) from personal);

-- 16. 15번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select pName, pay, p.dNo, dName
	from personal p, division d
    where p.dNo = d.dNo and pay > (select avg(pay) from personal)
    order by dName, pay desc;

-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
select pName, pay, p1.dNo, round(sum_by_dept,2)
	from personal p1, (select dNo, avg(pay) "sum_by_dept" from personal group by dNo) p2
    where p1.dNo = p2.dNo and pay > sum_by_dept; 
    

-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pName, pay, dName
	from personal p, division d
    where p.dNo = d.dNo
		and startdate = (select min(startdate) from personal);
        
-- 19. 이름, 급여, 해당부서평균
select pName, pay, avg_by_dept
	from personal p, (select dNo, avg(pay) "avg_by_dept" from personal group by dNo) a
    where p.dNo = a.dNo;

-- 20. 이름, 급여, 부서명, 해당부서평균
select pName, pay, avg_by_dept, dName
	from personal p, (select dNo, avg(pay) "avg_by_dept" from personal group by dNo) a, division d
    where p.dNo = a.dNo and p.dNo = d.dNo;
