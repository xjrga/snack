CREATE PROCEDURE getMixNutrientsAll (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT
NutrientId,
Name
FROM
Nutrient
ORDER BY nutrientid;
--
OPEN result;

--
END;
/
