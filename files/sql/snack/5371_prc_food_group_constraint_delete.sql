CREATE PROCEDURE FoodGroupQuantityConstraint_Delete (
IN v_MixId LONGVARCHAR,
IN v_GroupId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_RelationshipId INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM
FoodGroupQuantityC
WHERE
MixId = v_MixId
AND
GroupId = v_GroupId
AND
NutrientId = v_NutrientId
AND
RelationshipId = v_RelationshipId;
END;
/
