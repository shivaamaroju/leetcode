SELECT t.machine_id, 
      round((max(t.x)-min(t.x))/t.y,3) as processing_time
FROM (
    SELECT count(a.machine_id) as y,a.machine_id, round(SUM(a.timestamp),3) as x
    FROM Activity a
    WHERE activity_type = 'start' 
    GROUP BY a.machine_id
    union    
     SELECT count(b.machine_id) as y,b.machine_id, round(SUM(b.timestamp),3) as x
    FROM Activity b
    WHERE activity_type = 'end' 
    GROUP BY b.machine_id)
    AS t 
 GROUP BY t.machine_id;

--     UNION 

--     SELECT b.machine_id, MOD(SUM(b.timestamp), COUNT(b.machine_id)) AS x 
--     FROM Activity b
--     WHERE activity_type = 'end' 
--     GROUP BY b.machine_id
-- ) 
