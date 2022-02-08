CREATE PROCEDURE PercentNutrientConstraint_Select (
IN v_MixId INTEGER
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT
a.MixId,
a.FoodId,
a.NutrientId,
b.Name as Food,
c.Name as Nutrient,
a.b
FROM
PercentConstraint a, Food b, Nutrient c
WHERE
a.MixId = v_MixId
AND
a.FoodId = b.FoodId
AND
a.NutrientId = c.NutrientId
ORDER BY
a.NutrientId,a.FoodId;
--
OPEN result;
--
END;
/