--My SQL
select max(num) as num from (Select num from MyNumbers group by num having count(num)=1) as new_table

--Oracle
select max(num) as num from (Select num from MyNumbers group by num having count(num)=1)
