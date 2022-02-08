CREATE PROCEDURE PercentNutrientConstraint_Delete (
IN v_MixId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR
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
