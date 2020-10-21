-- HW 1014
use ssafydb;
select * from employees;
select * from departments;


-- 1) ‘Diana’ 사원과 같은 직무인 사원의 사번(employee_id), 이름(first_name),
-- 직무(job_id), 부서번호(department_id), 부서이름(department_name)을 출력하
-- 세요.

select e.employee_id, first_name, job_id, e.department_id, department_name
from employees e inner join departments d
on e.department_id = d.department_id
where job_id = (select job_id from employees where first_name = 'Diana');

-- 2) ‘Bruce’와 같은 매니저인 사원의 정보를 inline view로 사용하여 아래의 결과를 출력하세요.
-- 사번, 이름, 직무이름, 부서이름을 출력.
select employee_id, first_name, job_title, department_name
from (select manager_id from employees where first_name = 'Bruce') inline
inner join employees e
on inline.manager_id = e.manager_id
inner join departments d
on e.department_id = d.department_id
inner join jobs j
on e.job_id = j.job_id;

-- 3) 모든 사원을 입사일 순으로 정렬하고 가장 오래된 순으로 6번째부터 10번째까지 사원의
-- 정보를 출력하세요.
select employee_id, first_name, hire_date
from employees
order by hire_date
limit 5, 5;






