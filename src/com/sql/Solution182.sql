--182 Duplicate Emails
--oracle,mysql,sqlserver
select email from person
group by email having count(email)>1

SELECT email
FROM Person
GROUP BY email
HAVING count(*) > 1;

SELECT email
FROM Person
GROUP BY email
HAVING count(distinct ID) > 1;