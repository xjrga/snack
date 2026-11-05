CREATE PROCEDURE adjustExpectedWeight (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC
--
UPDATE
mealfoodportion c
SET
expectedwt = (
select a.pct * b.x as nweight
from
mealfoodportion a,
mixfood b
where
a.mixid = b.mixid and
a.foodid = b.foodid and
a.mixid = c.mixid and
a.foodid = c.foodid and
a.mealid = c.mealid
)
WHERE mixid = v_MixId;
--
END
/