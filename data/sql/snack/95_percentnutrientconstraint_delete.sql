CREATE PROCEDURE PercentNutrientConstraint_Delete (
IN v_MixId INTEGER,
IN v_FoodId VARCHAR(8000),
IN v_NutrientId VARCHAR(8000)
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM
PercentConstraint
WHERE
MixId = v_MixId
AND
FoodId = v_FoodId
AND
NutrientId = v_NutrientId;
END;
/
