CREATE PROCEDURE FoodNutrientRatio_Delete (
IN v_MixId INTEGER,
IN v_Food_Id_1 VARCHAR(8000),
IN v_Nutrient_Id_1 VARCHAR(8000),
IN v_Food_Id_2 VARCHAR(8000),
IN v_Nutrient_Id_2 VARCHAR(8000),
IN v_RelationshipId INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM
FoodNutrientRatio
WHERE
MixId = v_MixId
AND
Food_Id_1 = v_Food_Id_1
AND
Nutrient_Id_1 = v_Nutrient_Id_1
AND
Food_Id_2 = v_Food_Id_2
AND
Nutrient_Id_2 = v_Nutrient_Id_2
AND
RelationshipId = v_RelationshipId;
END;
/
