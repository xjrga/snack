CREATE PROCEDURE FoodGroupConstraint_Merge (
IN v_MixId LONGVARCHAR,
IN v_GroupId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_RelationshipId INTEGER,
IN v_b DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO FoodGroupQuantityC USING ( VALUES (
v_MixId,
v_GroupId,
v_NutrientId,
v_RelationshipId,
v_b
) ) ON (
MixId = v_MixId
AND
GroupId = v_GroupId
AND
NutrientId = v_NutrientId
AND
RelationshipId = v_RelationshipId
)
WHEN MATCHED THEN UPDATE SET
b = v_b
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_GroupId,
v_NutrientId,
v_RelationshipId,
v_b;
END;
/
