CREATE PROCEDURE NutrientRatio_Delete (
IN v_MixId INTEGER,
IN v_Nutrient_Id_1 LONGVARCHAR,
IN v_Nutrient_Id_2 LONGVARCHAR,
IN v_RelationshipId INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM
NutrientRatio
WHERE
MixId = v_MixId
AND
Nutrient_Id_1 = v_Nutrient_Id_1
AND
Nutrient_Id_2 = v_Nutrient_Id_2
AND
RelationshipId = v_RelationshipId;
END;
/
