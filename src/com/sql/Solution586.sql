SELECT customer_number
FROM orders
GROUP BY customer_number
ORDER BY COUNT(*) DESC
LIMIT 1;

with cte As (Select customer_number,count(order_number) as NumOrd from Orders
group by customer_number)
select customer_number from cte where NumOrd =(select max(NumOrd) from cte);