CREATE PROCEDURE nutrient_rhs (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT mixid,
       nutrientid,
       relationshipid,
       b,
       b.name as nutrient,
       c.name as eq
FROM NutrientQuantityC a, nutrient b, relationship c
WHERE mixid = v_MixId
AND a.nutrientid = b.nutrientid
AND a.relationshipid = c.relationshipid
ORDER BY nutrientid;
--
OPEN result;
--
END;
/
