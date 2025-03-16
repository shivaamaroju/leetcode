-- # Write your MySQL query statement below
-- select x.user_id,x.confirmation_rate from(select  * from Signups s left join(
-- select c.user_id,round(sum(case when action='confirmed' then 1 else 0 end)/count(*),2) as confirmation_rate from Confirmations  c group by user_id ) as t on s.user_id=t.user_id) as x;
select s.user_id, round(sum(case when c.action='confirmed' then 1 else 0 end)/count(*),2) as confirmation_rate  from Signups s left join Confirmations c on c.user_id=s.user_id group by s.user_id;