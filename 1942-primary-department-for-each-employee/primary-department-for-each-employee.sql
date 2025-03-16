# Write your MySQL query statement below
select t.employee_id,t.department_id from (select employee_id, count(employee_id) as x,department_id from Employee group  by employee_id) as t where t.x=1
UNION
select employee_id,department_id from Employee  where primary_flag='Y' group  by employee_id;