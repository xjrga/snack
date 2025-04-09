CREATE PROCEDURE selectDriNutrients()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT
NutrientId,
Name
FROM
Nutrient a
WHERE
a.NutrientId = '301' OR
a.NutrientId = '303' OR
a.NutrientId = '304' OR
a.NutrientId = '305' OR
a.NutrientId = '306' OR
a.NutrientId = '307' OR
a.NutrientId = '309' OR
a.NutrientId = '312' OR
a.NutrientId = '315' OR
a.NutrientId = '317' OR
a.NutrientId = '320' OR
a.NutrientId = '323' OR
a.NutrientId = '328' OR
a.NutrientId = '401' OR
a.NutrientId = '404' OR
a.NutrientId = '405' OR
a.NutrientId = '406' OR
a.NutrientId = '410' OR
a.NutrientId = '415' OR
a.NutrientId = '418' OR
a.NutrientId = '421' OR
a.NutrientId = '430' OR
a.NutrientId = '435'
ORDER BY Name;
--
OPEN result;
--
END;
/
