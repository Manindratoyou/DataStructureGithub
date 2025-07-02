--My SQL
SELECT
    sell_date,
    COUNT(DISTINCT product) AS num_sold,
    GROUP_CONCAT(DISTINCT product ORDER BY product ASC SEPARATOR ',') AS products
FROM
    Activities
GROUP BY
    sell_date
ORDER BY
    sell_date ASC;
--Oracle
SELECT
  TO_CHAR(sell_date, 'YYYY-MM-DD') AS sell_date,
  COUNT(DISTINCT product) AS num_sold,
  LISTAGG(product, ',') WITHIN GROUP (ORDER BY product) AS products
FROM (
  SELECT DISTINCT sell_date, product
  FROM Activities
)
GROUP BY sell_date
ORDER BY sell_date;