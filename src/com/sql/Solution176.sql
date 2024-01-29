--MySql:
SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee);

--PostgreSQL:
SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee);


--SQL Server:
WITH RankedSalaries AS (
    SELECT Salary, DENSE_RANK() OVER (ORDER BY Salary DESC) AS SalaryRank
    FROM Employee
)
SELECT MAX(Salary) AS SecondHighestSalary
FROM RankedSalaries
WHERE SalaryRank = 2;

--Oracle:
SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee);

SELECT * FROM EMP E1 WHERE 5=(SELECT COUNT(DISTINCT(SAL)) FROM EMP E2 WHERE E2.SAL>=E1.SAL);


