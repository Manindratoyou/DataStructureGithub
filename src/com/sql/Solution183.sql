--Customers Who Never Order
SELECT c.Name as Customers
FROM Customers c
LEFT JOIN Orders o ON c.Id = o.CustomerId
WHERE o.CustomerId IS NULL;

/* Write your PL/SQL query statement below */
SELECT c.name as "Customers"
FROM customers c
WHERE NOT EXISTS (SELECT o.customerId FROM orders o where c.id = o.customerId);

/* Write your PL/SQL query statement below */
select c.name as Customers from Customers c where c.id not in (select o.customerId  from Orders o);