--check all below once
--MySql
 SELECT Salary
FROM (
    SELECT Salary, DENSE_RANK() OVER (ORDER BY Salary DESC) AS SalaryRank
    FROM Employee
) AS RankedSalaries
WHERE SalaryRank = N
LIMIT 1;
--PostgreSQL:
SELECT Salary
FROM (
    SELECT Salary, DENSE_RANK() OVER (ORDER BY Salary DESC) AS SalaryRank
    FROM Employee
) AS RankedSalaries
WHERE SalaryRank = N
LIMIT 1;

--SQL Server:
SELECT Salary
FROM (
    SELECT Salary, DENSE_RANK() OVER (ORDER BY Salary DESC) AS SalaryRank
    FROM Employee
)
WHERE SalaryRank = N


--Oracle:

SELECT Salary
FROM (
    SELECT Salary, DENSE_RANK() OVER (ORDER BY Salary DESC) AS SalaryRank
    FROM Employee)
WHERE SalaryRank = N