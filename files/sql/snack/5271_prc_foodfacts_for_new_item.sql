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
       CAST(0.0 AS DECIMAL(25,18)
) AS q
FROM NutrientCategory a,
     Nutrient b
WHERE a.NutrientCategoryId = b.NutrientCategoryId
AND b.Calculated = 0
ORDER BY a.Name,
         b.Name;
--
OPEN result;
--
END;
/