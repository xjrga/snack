CREATE PROCEDURE Nutrient_To_Pct_Select ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT
NutrientId,
Name,
q
FROM
Nutrient a, Rda b
WHERE
a.NutrientId = b.NutrientId AND
b.LifeStageId = 22 AND
a.NutrientId != '204' AND
a.NutrientId != '255' AND
a.NutrientId != '291' AND
a.NutrientId != '313' AND
a.NutrientId != '618' AND
a.NutrientId != '619' AND
a.NutrientId != '10001' AND
a.NutrientId != '10003'
ORDER BY Name;
--
OPEN result;
--
END;
/
