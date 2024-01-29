--comment
--MySql:
SELECT Person.FirstName, Person.LastName, Address.City, Address.State
FROM Person
LEFT JOIN Address ON Person.PersonId = Address.PersonId;

--PostgreSQL:
SELECT Person.FirstName, Person.LastName, Address.City, Address.State
FROM Person
LEFT JOIN Address ON Person.PersonId = Address.PersonId;

--SQL Server:
SELECT Person.FirstName, Person.LastName, Address.City, Address.State
FROM Person
LEFT JOIN Address ON Person.PersonId = Address.PersonId;

--Oracle:
SELECT Person.FirstName, Person.LastName, Address.City, Address.State
FROM Person
LEFT JOIN Address ON Person.PersonId = Address.PersonId;

