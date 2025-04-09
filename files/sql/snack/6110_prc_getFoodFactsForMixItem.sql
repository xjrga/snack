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
AND (b.NutrientId != '10003' AND b.NutrientId != '10009' AND b.NutrientId != '10010' AND b.NutrientId != '10011' AND b.NutrientId != '10012' AND b.NutrientId != '10013' AND b.NutrientId != '10014' AND b.NutrientId != '10015' AND b.NutrientId != '10016')
GROUP BY NutrientId, Category, Nutrient
ORDER BY Category,Nutrient;
--
OPEN result;
--
END;
/