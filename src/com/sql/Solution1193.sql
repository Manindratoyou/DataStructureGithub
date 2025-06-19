--My SQL
Select  date_format(trans_date,'%Y-%m') as month , country ,count(id) as trans_count ,
sum(if(state='approved',1,0)) as  approved_count ,
sum(amount) as trans_total_amount ,sum(if(state='approved',amount,0)) as approved_total_amount
from Transactions group by month ,country

--Oracle
SELECT
  TO_CHAR(trans_date, 'YYYY-MM') AS month,
  country,
  COUNT(id) AS trans_count,
  SUM(CASE WHEN state = 'approved' THEN 1 ELSE 0 END) AS approved_count,
  SUM(amount) AS trans_total_amount,
  SUM(CASE WHEN state = 'approved' THEN amount ELSE 0 END) AS approved_total_amount
FROM
  Transactions
GROUP BY
  TO_CHAR(trans_date, 'YYYY-MM'), country;
