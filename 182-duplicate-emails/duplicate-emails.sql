# Write your MySQL query statement below
select email from (select email,count(email) as d from Person group by email)as t where d>1; 