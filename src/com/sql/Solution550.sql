--MY SQL
Select round(sum(player_login) / count(distinct player_id),2) as fraction
from
(select player_id , datediff(event_date ,min(event_date)over
(partition by player_id))=1 as player_login from Activity) as new_table

--Oracle
SELECT
  ROUND(SUM(player_login) / COUNT(DISTINCT player_id), 2) AS fraction
FROM (
  SELECT
    player_id,
    CASE
      WHEN event_date - MIN(event_date) OVER (PARTITION BY player_id) = 1
      THEN 1
      ELSE 0
    END AS player_login
  FROM Activity
);
