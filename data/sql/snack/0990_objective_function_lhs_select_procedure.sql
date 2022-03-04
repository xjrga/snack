CREATE PROCEDURE objective_lhs (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT foodid,
       c
FROM mixfood a, foodfactcoefficient b
WHERE mixid = v_mixid
AND
a.foodid = b.foodid
AND
b.nutrientid = (SELECT a.nutrientid FROM mix a WHERE a.mixid = v_mixid)
ORDER BY foodid;
--
OPEN result;
--
END;
/
