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
a.NutrientId != '203' AND
a.NutrientId != '204' AND
a.NutrientId != '205' AND
a.NutrientId != '208' AND
a.NutrientId != '210' AND
a.NutrientId != '212' AND
a.NutrientId != '213' AND
a.NutrientId != '221' AND
a.NutrientId != '255' AND
a.NutrientId != '291' AND
a.NutrientId != '421' AND
a.NutrientId != '601' AND
a.NutrientId != '606' AND
a.NutrientId != '621' AND
a.NutrientId != '629' AND
a.NutrientId != '645' AND
a.NutrientId != '646' AND
a.NutrientId != '675' AND
a.NutrientId != '851' AND
a.NutrientId != '10001' AND
a.NutrientId != '10003'
ORDER BY Name;
--
OPEN result;
--
END;
/
