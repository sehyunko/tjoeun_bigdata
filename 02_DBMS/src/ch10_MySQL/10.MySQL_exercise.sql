-- �������� 

-- 1. ���, �̸�, �޿��� ���
select pNo, pName, pay from personal;

-- 2. �޿��� 2000~5000 ���� ��� ������ ��� �ʵ�
select * from personal 
	where pay between 2000 and 5000;

-- 3. �μ���ȣ�� 10�Ǵ� 20�� ����� ���, �̸�, �μ���ȣ
select pNo, pName, dNo from personal 
	where dNo in (10,20); 

-- 4. ���ʽ��� null�� ����� ���, �̸�, �޿� �޿� ū ������
select pNo, pName, pay from personal 
	where bonus is null
    order by pay desc; 

-- 5. ���, �̸�, �μ���ȣ, �޿�. �μ��ڵ� �� ���� ������ PAY ū��
select pNo, pName, dNo, pay from personal 
	order by dNo, pay desc;

-- 6. ���, �̸�, �μ���
select pNo, pName, dName from personal p, division d
	where p.dNo = d.dNo;
    
-- 7. ���, �̸�, ����̸�
select w.pNo, w.pName, m.pName "manager" from personal w, personal m
	where w.manager = m.pNo;

-- 8. ���, �̸�, ����̸�(��簡 ���� ����� ���)
select w.pNo, w.pName "worker", ifnull(m.pName,'no manager') "manager" 
	from personal w
    left join personal m on w.manager = m.pNo;

select w.pNo, w.pName "worker", if(m.pName is null,'no manager',m.pName) "manager" 
	from personal w
    left join personal m on w.manager = m.pNo;

-- 9. �̸��� s�� �����ϴ� ��� �̸�
select pName from personal 
	where pName like 's%';

-- 10. ���, �̸�, �޿�, �μ���, ����̸�
select w.pNo, w.pName, w.pay, dName, m.pName "manager"
	from personal w, personal m, division d
    where w.pNo = m.pNo and w.dNo = d.dNo;

-- 11. �μ��ڵ�, �޿��հ�, �ִ�޿�
select distinct dNo, sum(pay), max(pay)
	from personal
    group by dNo;

-- 12. �μ���, �޿����, �ο���
select dName, avg(pay), count(*)
	from personal p,division d
		where p.dNo = d.dNo
        group by dName ;
-- 13. �μ��ڵ�, �޿��հ�, �ο��� �ο����� 4�� �̻��� �μ��� ���
select dNo, sum(pay), count(*)
	from personal
    group by dNo
    having count(*) >= 4;
-- 14. ���, �̸�, �޿� ȸ�翡�� ���� �޿��� ���� �޴� ���
select pNo, pName, pay
	from personal 
    where pay = (select max(pay) from personal);

-- 15. ȸ�� ��պ��� �޿��� ���� �޴� ��� �̸�, �޿�, �μ���ȣ
select pName, pay, dNo 
	from personal 
    where pay > (select avg(pay) from personal);

-- 16. 15���� �μ����� �߰��ϰ� �μ���� ���� ������ �޿� ū��
select pName, pay, p.dNo, dName
	from personal p, division d
    where p.dNo = d.dNo and pay > (select avg(pay) from personal)
    order by dName, pay desc;

-- 17. �ڽ��� ���� �μ��� ��պ��� ���� �޴� ����� �̸�, �ݿ�, �μ���ȣ, �ݿø��� �ش�μ����
select pName, pay, p1.dNo, round(sum_by_dept,2)
	from personal p1, (select dNo, avg(pay) "sum_by_dept" from personal group by dNo) p2
    where p1.dNo = p2.dNo and pay > sum_by_dept; 
    

-- 18. �Ի簡 ���� ���� ����� �̸�, �޿�, �μ���
select pName, pay, dName
	from personal p, division d
    where p.dNo = d.dNo
		and startdate = (select min(startdate) from personal);
        
-- 19. �̸�, �޿�, �ش�μ����
select pName, pay, avg_by_dept
	from personal p, (select dNo, avg(pay) "avg_by_dept" from personal group by dNo) a
    where p.dNo = a.dNo;

-- 20. �̸�, �޿�, �μ���, �ش�μ����
select pName, pay, avg_by_dept, dName
	from personal p, (select dNo, avg(pay) "avg_by_dept" from personal group by dNo) a, division d
    where p.dNo = a.dNo and p.dNo = d.dNo;