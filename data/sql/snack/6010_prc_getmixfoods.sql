CREATE PROCEDURE getMixFoods(IN v_MixId LONGVARCHAR)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT FoodId
FROM MixFood
WHERE MixId = v_MixId
ORDER BY FoodId;
--
OPEN result;
--
END;
/
