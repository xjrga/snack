CREATE PROCEDURE NutrientConstraint_Delete (
IN v_MixId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_RelationshipId INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM
NutrientQuantityC
WHERE
MixId = v_MixId
AND
NutrientId = v_NutrientId
AND
RelationshipId = v_RelationshipId;
END;
/
