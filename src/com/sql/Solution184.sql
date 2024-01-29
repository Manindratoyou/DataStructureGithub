--oracle 184. Department Highest Salary
SELECT D.NAME AS Department,
       E.NAME AS Employee,
       E.SALARY AS Salary
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.departmentId = D.ID
WHERE (E.departmentId, E.SALARY) IN (
    SELECT departmentId, MAX(SALARY) AS SALARY
    FROM EMPLOYEE
    GROUP BY departmentId
);
