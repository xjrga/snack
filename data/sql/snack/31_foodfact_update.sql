CREATE PROCEDURE FoodFact_Update (
IN v_FoodId VARCHAR(8000),
IN v_NutrientId VARCHAR(8000),
IN v_q DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE
FoodFact
SET
q = v_q
WHERE
FoodId = v_FoodId
AND
NutrientId = v_NutrientId;
END;
/
