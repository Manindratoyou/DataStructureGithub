select w1.id from Weather w1 , Weather w2
where w1.recordDate=w2.recordDate+1 and
w1.temperature >w2.temperature

SELECT w1.id
FROM Weather w1
JOIN Weather w2
  ON TRUNC(w1.recordDate) = TRUNC(w2.recordDate) + 1
WHERE w1.temperature > w2.temperature;


select w1.id from Weather w1 join Weather w2
on w1.recordDate=w2.recordDate+1 and
w1.temperature >w2.temperature