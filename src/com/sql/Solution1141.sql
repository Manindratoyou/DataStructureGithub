--My SQL
select  activity_date as day , count(distinct(user_id)) as active_users
from activity where activity_date between date_sub('2019-07-27' , interval 29 day )
and '2019-07-27' group by day

--Oracle
SELECT TO_CHAR(TRUNC(activity_date), 'YYYY-MM-DD') AS day,
       COUNT(DISTINCT user_id) AS active_users
FROM activity
WHERE activity_date BETWEEN TO_DATE('2019-07-27', 'YYYY-MM-DD') - 29
                        AND TO_DATE('2019-07-27', 'YYYY-MM-DD')
GROUP BY TRUNC(activity_date)
ORDER BY day;