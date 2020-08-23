create schema employeeDB;
use employeeDB;

create table employee(
	empNo int not null,
    empName varchar(30) not null,
    empPosition varchar(30) not null,
    empDept varchar(30),
    primary key (empNo)
);

insert into employee (empNo, empName, empPosition, empDept ) values(100,'홍길동','대리','인사');
insert into employee (empNo, empName, empPosition, empDept ) values(200,'임창정','과장','재무');
insert into employee (empNo, empName, empPosition, empDept ) values(300,'김태희','사원','인사');