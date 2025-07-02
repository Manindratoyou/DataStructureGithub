--My SQL--
WITH daily AS (
  SELECT visited_on, SUM(amount) AS amount
  FROM Customer
  GROUP BY visited_on
),
daily_with_index AS (
  SELECT
    visited_on,
    amount,
    ROW_NUMBER() OVER (ORDER BY visited_on) AS rn
  FROM daily
)
SELECT
  d1.visited_on,
  SUM(d2.amount) AS amount,
  ROUND(SUM(d2.amount)/7, 2) AS average_amount
FROM daily_with_index d1
JOIN daily_with_index d2
  ON d2.rn BETWEEN d1.rn - 6 AND d1.rn
WHERE d1.rn >= 7
GROUP BY d1.visited_on
ORDER BY d1.visited_on;

--Oracle--
WITH daily AS (
  SELECT visited_on, SUM(amount) AS amount
  FROM Customer
  GROUP BY visited_on
),
daily_with_index AS (
  SELECT visited_on, amount,
         ROW_NUMBER() OVER (ORDER BY visited_on) AS rn
  FROM daily
),
rolling_7_day AS (
  SELECT d1.visited_on,
         SUM(d2.amount) AS amount,
         ROUND(SUM(d2.amount) / 7, 2) AS average_amount
  FROM daily_with_index d1
  JOIN daily_with_index d2
    ON d2.rn BETWEEN d1.rn - 6 AND d1.rn
  WHERE d1.rn >= 7
  GROUP BY d1.visited_on
)
SELECT TO_CHAR(visited_on, 'YYYY-MM-DD') AS visited_on,
       amount,
       average_amount
FROM rolling_7_day
ORDER BY visited_on;
