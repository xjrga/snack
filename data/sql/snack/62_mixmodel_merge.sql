CREATE PROCEDURE MixModel_Merge (
IN v_MixId INTEGER,
IN v_NutrientId LONGVARCHAR,
IN v_Model LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO MixModel USING ( VALUES (
v_MixId,
v_NutrientId,
v_Model
) ) ON (
MixId = v_MixId
)
WHEN MATCHED THEN UPDATE SET
NutrientId = v_NutrientId,
Model = v_Model
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_NutrientId,
v_Model;
END;
/