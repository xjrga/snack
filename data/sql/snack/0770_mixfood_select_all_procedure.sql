CREATE PROCEDURE MixFood_Select_All (IN v_mixid INTEGER)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
a.FoodId,
b.Name
FROM
MixFood a, Food b
WHERE
a.foodid = b.foodid
AND
a.mixid = v_mixid
ORDER BY a.FoodId;
OPEN result;
END;
/
