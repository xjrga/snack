CREATE PROCEDURE FoodNutrientConstraint_Delete (
IN v_MixId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_RelationshipId INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM
FoodNutrientConstraint
WHERE
MixId = v_MixId
AND
FoodId = v_FoodId
AND
NutrientId = v_NutrientId
AND
RelationshipId = v_RelationshipId;
END;
/
