CREATE PROCEDURE getFoodFactsForMixItem(
IN v_MixId LONGVARCHAR
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT b.NutrientId,
       a.Name AS Category,
       b.Name AS Nutrient,
       sum(c.q) AS q
FROM NutrientCategory a,
     Nutrient b,
     MixResult c
WHERE a.NutrientCategoryId = b.NutrientCategoryId
AND   b.NutrientId = c.NutrientId
AND c.MixId = v_MixId
AND b.Calculated = 0
GROUP BY NutrientId, Category, Nutrient
ORDER BY Category,Nutrient;
--
OPEN result;
--
END;
/