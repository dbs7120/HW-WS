-- DB 과제
select * from emp;
select * from dept;
select * from salgrade;

-- 1) 30번 부서에 속한 사원의 이름과 부서번호 그리고 부서이름을 출력하라
select ename, emp.deptno, dname from emp inner join dept on emp.deptno = dept.deptno where emp.deptno = 30;

-- 2) 30번 부서에 속한 사원들의 모든 직업과 부서위치를 출력하라 (단 , 직업 목록이 중복되지 않게 하라)
select distinct job, loc from emp inner join dept on emp.deptno = dept.deptno where emp.deptno = (select deptno from dept where deptno = 30);

-- 3) 커미션이 책정되어 있는 모든 사원의 이름 , 부서이름 및 위치를 출력하라
select ename, dname, loc from emp inner join dept on emp.deptno = dept.deptno where not isnull(comm);

-- 4) 이름에 A 가 들어가는 모든 사원의 이름과 부서 이름을 출력하라
select ename, dname from emp inner join dept on emp.deptno = dept.deptno where ename like '%A%';

-- 5) Dallas에서 근무하는 모든 사원의 이름 , 직업 , 부서번호 및 부서이름을 출력하라
select ename, job, deptno from emp where deptno = (select deptno from dept where loc = 'Dallas');

-- 6) 사원이름 및 사원번호 , 해당 관리자이름 및 관리자 번호를 출력하되 , 각 컬럼명을 employee,emp#, manager,mgr 으로 표시하여 출력하라
select ename as employee, empno as 'emp#', (select ename from emp where empno = outter.mgr) as manager, mgr from emp outter;

-- 7) 모든 사원의 이름 직업 부서이름 급여 및 등급을 출력하라
select ename, job, dname, sal, grade from emp,salgrade, dept where emp.sal between salgrade.losal and salgrade.hisal;

-- 8) Smith보다 늦게 입사한 사원의 이름 및 입사일을 출력하라
select ename, hiredate from emp where hiredate > (select hiredate from emp where ename = 'Smith');

-- 9) 자신의 관리자보다 먼저 입사한 모든 사원의 이름, 입사일, 관리자의 이름, 관리자의 입사일을 출력하되 각각 컬럼명을 
--    Employee, EmpHiredate, Manager, MgrHiredate 로 표시하여 출력하라
select e.ename Employee, e.hiredate EmpHiredate, m.ename Manager, m.hiredate MgrHiredate from emp e join emp m on e.mgr = m.empno where e.hiredate < m.hiredate;
	
-- 10) Smith와 동일한 부서에 속한 모든 사원의 이름 및 입사일을 출력하라 (단 , Smith 는 제외하고 출력하시오)
select ename, hiredate from emp where deptno = (select deptno from emp where ename = 'Smith') and not ename = 'Smith';

-- 11) 자신의 급여가 평균 급여보다 많은 모든 사원의 사원 번호 , 이름 , 급여를 표시하는 질의를 작성하고 급여를 기준으로 결과를 내림차순으로 정렬하라
select empno, ename, sal from emp where sal > (select avg(sal) from emp) order by sal desc;

-- 12) 이름에 T 가 들어가는 사원의 속한 부서에서 근무하는 모든 사원의 사원번호 및 이름을 출력하라
select empno, ename from emp where deptno in (select distinct deptno from emp where ename like '%T%');

-- 13) 자신의 급여가 평균 급여보다 많고 이름에 T 가 들어가는 사원과 동일한 부서에 근무하는 모든 사원의 사원 번호 , 이름 및 급여를 출력하라
select empno, ename, sal from emp where deptno in (select distinct deptno from emp where ename like '%T%' and sal > (select avg(sal) from emp));

-- 14) 직업이 Clerk 인 사원들보다 더 많은 급여를 받는 사원의 사원번호 , 이름 , 급여를 출력하되 , 결과를 급여가 높은 순으로 정렬하라
select empno, ename, sal from emp where sal > all (select sal from emp where job = 'Clerk') order by sal desc;

-- 15) New York에서 근무하는 사원과 급여 및 커미션이 같은 사원의 사원이름과 부서명을 출력하라
select ename, dname from emp inner join dept on emp.deptno = dept.deptno where (sal, ifnull(comm, 'null')) in (select sal, ifnull(comm, 'null') from emp where loc = 'New York'); 

