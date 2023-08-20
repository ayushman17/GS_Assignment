#-----------------------------------------------------------------------------------------------
#A-I
#-----------------------------------------------------------------------------------------------

#1.
#-----------------------------------------------------------------------------------------------

mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| employee           |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.04 sec)

mysql> create database assignment;
Query OK, 1 row affected (0.02 sec)

mysql> use assignment;
Database changed

mysql> show tables;
Empty set (0.01 sec)

mysql> create table department (dept_no int primary key, dept_name text, dept_location text);
Query OK, 0 rows affected (0.01 sec)

mysql> desc department;
+---------------+------+------+-----+---------+-------+
| Field         | Type | Null | Key | Default | Extra |
+---------------+------+------+-----+---------+-------+
| dept_no       | int  | NO   | PRI | NULL    |       |
| dept_name     | text | YES  |     | NULL    |       |
| dept_location | text | YES  |     | NULL    |       |
+---------------+------+------+-----+---------+-------+
3 rows in set (0.01 sec)

mysql> insert into department (dept_no, dept_name, dept_location) values (101, 'hr department', 'bengaluru'), (102, 'it department', 'hyderabad'), (103, 'sales department', 'hyderabad');
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> select *from department;
+---------+------------------+---------------+
| dept_no | dept_name        | dept_location |
+---------+------------------+---------------+
|     101 | hr department    | bengaluru     |
|     102 | it department    | hyderabad     |
|     103 | sales department | hyderabad     |
+---------+------------------+---------------+
3 rows in set (0.01 sec)

#-------------------------------------------------------------------------------------------------------------------------------------
#2.
#-------------------------------------------------------------------------------------------------------------------------------------

mysql> create table employee ( emp_no int primary key, emp_name varchar(255), emp_age int check (emp_age >= 18), emp_gender char(1) check (emp_gender in ('m', 'f')), dept_no int, foreign key (dept_no) references department(dept_no) on delete cascade );
Query OK, 0 rows affected (0.03 sec)

mysql> show tables;
+----------------------+
| Tables_in_assignment |
+----------------------+
| department           |
| employee             |
+----------------------+
2 rows in set (0.01 sec)

mysql> desc employee;
+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| emp_no     | int          | NO   | PRI | NULL    |       |
| emp_name   | varchar(255) | YES  |     | NULL    |       |
| emp_age    | int          | YES  |     | NULL    |       |
| emp_gender | char(1)      | YES  |     | NULL    |       |
| dept_no    | int          | YES  | MUL | NULL    |       |
+------------+--------------+------+-----+---------+-------+
5 rows in set (0.00 sec)

mysql> insert into employee (emp_no, emp_name, emp_age, emp_gender, dept_no) values (1001, 'shaktimaan', 25, 'm', 101), (1002, 'rupali', 30, 'f', 103), (1003, 'spider-man', 28, 'm', 101), (1004, 'ayushman', 22, 'm', 102);
Query OK, 4 rows affected (0.01 sec)
Records: 4  Duplicates: 0  Warnings: 0

mysql> select *from employee;
+--------+------------+---------+------------+---------+
| emp_no | emp_name   | emp_age | emp_gender | dept_no |
+--------+------------+---------+------------+---------+
|   1001 | shaktimaan |      25 | m          |     101 |
|   1002 | rupali     |      30 | f          |     103 |
|   1003 | spider-man |      28 | m          |     101 |
|   1004 | ayushman   |      22 | m          |     102 |
+--------+------------+---------+------------+---------+
4 rows in set (0.00 sec)

mysql> delete from department where dept_no = 101;
Query OK, 1 row affected (0.01 sec)

mysql> select *from employee;
+--------+----------+---------+------------+---------+
| emp_no | emp_name | emp_age | emp_gender | dept_no |
+--------+----------+---------+------------+---------+
|   1002 | rupali   |      30 | f          |     103 |
|   1004 | ayushman |      22 | m          |     102 |
+--------+----------+---------+------------+---------+
2 rows in set (0.00 sec)

mysql> select *from department;                                                                                                  
| dept_no | dept_name        | dept_location |
+---------+------------------+---------------+
|     102 | it department    | hyderabad     |
|     103 | sales department | hyderabad     |
+---------+------------------+---------------+
2 rows in set (0.00 sec)
