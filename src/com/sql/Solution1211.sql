--MySql
select query_name , round(avg(rating/position),2) as quality ,
round(avg(if(rating<3,1,0)*100),2)  as poor_query_percentage
from Queries  group by query_nameselect query_name , round(avg(rating/position),2) as quality ,
round(avg(if(rating<3,1,0)*100),2)  as poor_query_percentage
from Queries  group by query_name

--Oracle
SELECT
  query_name,
  ROUND(AVG(rating / position), 2) AS quality,
  ROUND(AVG(CASE WHEN rating < 3 THEN 1 ELSE 0 END) * 100, 2) AS poor_query_percentage
FROM
  Queries
GROUP BY
  query_name;
