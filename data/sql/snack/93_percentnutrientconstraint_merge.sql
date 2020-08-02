CREATE PROCEDURE PercentNutrientConstraint_Merge (
IN v_MixId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_b DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO PercentConstraint USING ( VALUES (
v_MixId,
v_FoodId,
v_NutrientId,
v_b
) ) ON (
MixId = v_MixId
AND
FoodId = v_FoodId
AND
NutrientId = v_NutrientId
)
WHEN MATCHED THEN UPDATE SET
b = v_b
WHEN NOT MATCHED THEN INSERT VALUES
v_MixId,
v_FoodId,
v_NutrientId,
v_b;
END;
/