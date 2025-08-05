CREATE PROCEDURE getFoodFactsForNewItem()
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
       CAST(0.0 AS DECIMAL(28,18)
) AS q
FROM NutrientCategory a,
     Nutrient b
WHERE a.NutrientCategoryId = b.NutrientCategoryId
AND   (b.NutrientId != '10003' AND b.NutrientId != '10009' AND b.NutrientId != '10010' AND b.NutrientId != '10011' AND b.NutrientId != '10012' AND b.NutrientId != '10013' AND b.NutrientId != '10014' AND b.NutrientId != '10015' AND b.NutrientId != '10016')
ORDER BY a.Name,
         b.Name;
--
OPEN result;
--
END;
/