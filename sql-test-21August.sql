#Q-I
select e.emp_no, e.emp_name,e.emp_sal,d.dpt_name, a.city,a.state from employee e inner join department d on e.deptno = d.deptno inner join address on d.address_id = a.address_id;

#Q-II
#1
create table bankaccount (acc_no int primary key, acc_opened_date date, status text, balance double);
#2
create table transaction (acc_no int,trans_type text, trans_date date, trans_amount double, foreign key transaction (acc_no) references bankaccount(acc_no) on delete cascade);


#Q-III

#1
select e1.emp_name as manager_name, e2.department sum(e2.emp_sal) as total_salary from employee e1 join employee e2 on e1.emp_no = e2.manager_name group by e1.emp_name,e2.department; 
#2
select distinct emp_sal from employee order by emp_sal desc limit 1 offset 3;