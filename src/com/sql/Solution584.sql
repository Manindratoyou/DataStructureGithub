select name
from Customer c
where c.referee_id is null or c.referee_id !=2;
select name
from Customer c
where c.referee_id is null or c.referee_id <>2;

--solution2
select name from Customer where referee_id != 2 or referee_id is null;