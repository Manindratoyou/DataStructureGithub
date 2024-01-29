select name
from Customer c
where c.referee_id is null or c.referee_id !=2;
select name
from Customer c
where c.referee_id is null or c.referee_id <>2;