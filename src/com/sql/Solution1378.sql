select eu.unique_id ,e.name from Employees e left join EmployeeUNI eu on  e.id=eu.id

--solution 2
select b.unique_id, a.name
from Employees a left join EmployeeUNI b
on a.id = b.id