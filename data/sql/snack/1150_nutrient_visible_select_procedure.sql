CREATE PROCEDURE Nutrient_Select_All_Visible ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT
NutrientId,
Name,
Visible
FROM
Nutrient
WHERE
Visible = 1 AND
NutrientId != '205' AND 
NutrientId != '675' AND 
NutrientId != '851'
ORDER BY Name;
--
OPEN result;
--
END;
/
