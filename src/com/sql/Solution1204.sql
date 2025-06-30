--MY SQL
select q1.person_name from Queue q1 inner join Queue q2 on q1.turn >=q2.turn
group by q1.turn having sum(q2.weight) <=1000
order by q1.turn desc limit 1

--Oracle
SELECT person_name
FROM (
    SELECT q1.person_name
    FROM Queue q1
    JOIN Queue q2 ON q1.turn >= q2.turn
    GROUP BY q1.person_name, q1.turn
    HAVING SUM(q2.weight) <= 1000
    ORDER BY q1.turn DESC
)
WHERE ROWNUM = 1;

