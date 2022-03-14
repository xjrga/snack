CREATE PROCEDURE MixFood_Select_All_By_Name (IN v_MixId LONGVARCHAR)
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
ORDER BY b.Name;
OPEN result;
END;
/
