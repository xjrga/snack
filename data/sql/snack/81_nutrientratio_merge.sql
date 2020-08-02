CREATE PROCEDURE NutrientRatio_Merge (
IN v_MixId INTEGER,
IN v_Nutrient_Id_1 LONGVARCHAR,
IN v_Nutrient_Id_2 LONGVARCHAR,
IN v_RelationshipId INTEGER,
IN v_A DOUBLE,
IN v_B DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO NutrientRatio USING ( VALUES (
v_MixId,
v_Nutrient_Id_1,
v_Nutrient_Id_2,
v_RelationshipId,
v_A,
v_B
) ) ON (
MixId = v_MixId
AND
Nutrient_Id_1 = v_Nutrient_Id_1
AND
Nutrient_Id_2 = v_Nutrient_Id_2
AND
RelationshipId = v_RelationshipId
)
WHEN MATCHED THEN UPDATE SET
A = v_A,
B = v_B
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_Nutrient_Id_1,
v_Nutrient_Id_2,
v_RelationshipId,
v_A,
v_B;
END;
/
