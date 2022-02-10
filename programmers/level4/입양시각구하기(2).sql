set @HOUR := -1;

select (@HOUR := @HOUR +1) HOUR , (select count(*)
from ANIMAL_OUTS 
WHERE HOUR(DATETIME) = @HOUR) COUNT from ANIMAL_OUTS where @HOUR < 23
