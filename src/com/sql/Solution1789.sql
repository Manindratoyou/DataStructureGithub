--MY SQL
SELECT employee_id, department_id
FROM Employee
WHERE primary_flag = 'Y'

UNION

SELECT employee_id, department_id
FROM Employee
GROUP BY employee_id
HAVING COUNT(*) = 1;

--oracle
SELECT DISTINCT employee_id, department_id
FROM Employee
WHERE primary_flag = 'Y'

UNION

SELECT employee_id, MIN(department_id)
FROM Employee
GROUP BY employee_id
HAVING COUNT(*) = 1;
