#--------------------------------------------------------------------------------------------------------------------------------------------------------
#A-II
#--------------------------------------------------------------------------------------------------------------------------------------------------------

#1.
#--------------------------------------------------------------------------------------------------------------------------------------------------------


mysql> create table course (course_id int, course_name text, course_credit int);
Query OK, 0 rows affected (0.01 sec)

mysql> insert into course values (101, 'Physicse', 3), (102, 'Chemistry', 4), (103, 'Maths', 5); 
Query OK, 3 rows affected (0.00 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> select *from course;
+-----------+-------------+---------------+
| course_id | course_name | course_credit |
+-----------+-------------+---------------+
|       101 | Physicse    |             3 |
|       102 | Chemistry   |             4 |
|       103 | Maths       |             5 |
+-----------+-------------+---------------+
3 rows in set (0.00 sec)

mysql> create table course_copy as select * from course;
Query OK, 3 rows affected (0.02 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> show tables;
+----------------------+
| Tables_in_assignment |
+----------------------+
| course               |
| course_copy          |
| department           |
| employee             |
+----------------------+
4 rows in set (0.00 sec)

mysql> select *from course_copy;
+-----------+-------------+---------------+
| course_id | course_name | course_credit |
+-----------+-------------+---------------+
|       101 | Physicse    |             3 |
|       102 | Chemistry   |             4 |
|       103 | Maths       |             5 |
+-----------+-------------+---------------+
3 rows in set (0.00 sec)

#--------------------------------------------------------------------------------------------------------------------------------------------------------
#2.
#--------------------------------------------------------------------------------------------------------------------------------------------------------

mysql> alter table course add column course_description text, add column course_faculty varchar(50);
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> select *from course;
+-----------+-------------+---------------+--------------------+----------------+
| course_id | course_name | course_credit | course_description | course_faculty |
+-----------+-------------+---------------+--------------------+----------------+
|       101 | Physicse    |             3 | NULL               | NULL           |
|       102 | Chemistry   |             4 | NULL               | NULL           |
|       103 | Maths       |             5 | NULL               | NULL           |
+-----------+-------------+---------------+--------------------+----------------+
3 rows in set (0.00 sec)

mysql> alter table course drop column course_description, drop column course_faculty;
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> select *from course;
+-----------+-------------+---------------+
| course_id | course_name | course_credit |
+-----------+-------------+---------------+
|       101 | Physicse    |             3 |
|       102 | Chemistry   |             4 |
|       103 | Maths       |             5 |
+-----------+-------------+---------------+
3 rows in set (0.00 sec)

mysql> alter table course change column course_name new_course_name text;
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> select *from course;
+-----------+-----------------+---------------+
| course_id | new_course_name | course_credit |
+-----------+-----------------+---------------+
|       101 | Physicse        |             3 |
|       102 | Chemistry       |             4 |
|       103 | Maths           |             5 |
+-----------+-----------------+---------------+
3 rows in set (0.00 sec)
