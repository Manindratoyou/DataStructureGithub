--MY Sql
SELECT 'Low Salary' AS category, COUNT(*) AS accounts_count
FROM Accounts
WHERE income < 20000

UNION ALL

SELECT 'Average Salary', COUNT(*)
FROM Accounts
WHERE income BETWEEN 20000 AND 50000

UNION ALL

SELECT 'High Salary', COUNT(*)
FROM Accounts
WHERE income > 50000;

--Oracle
SELECT 'Low Salary' AS category, COUNT(*) AS accounts_count
FROM Accounts
WHERE income < 20000

UNION ALL

SELECT 'Average Salary', COUNT(*)
FROM Accounts
WHERE income BETWEEN 20000 AND 50000

UNION ALL

SELECT 'High Salary', COUNT(*)
FROM Accounts
WHERE income > 50000;
 --or ---- one test case is failing
SELECT
  CASE
    WHEN income < 20000 THEN 'Low Salary'
    WHEN income <= 50000 THEN 'Average Salary'
    ELSE 'High Salary'
  END AS category,
  COUNT(*) AS accounts_count
FROM Accounts
GROUP BY
  CASE
    WHEN income < 20000 THEN 'Low Salary'
    WHEN income <= 50000 THEN 'Average Salary'
    ELSE 'High Salary'
  END;
