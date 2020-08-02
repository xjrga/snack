CREATE PROCEDURE FoodFactCoefficient_Update (
--
IN v_FoodId LONGVARCHAR,
--
IN v_NutrientId LONGVARCHAR
--
)
MODIFIES SQL DATA BEGIN ATOMIC
--
UPDATE
FoodFactCoefficient
SET
c = getFoodCoefficient(v_FoodId,v_NutrientId)
WHERE
FoodId = v_FoodId
AND
NutrientId = v_NutrientId;
--
END;
/