CREATE PROCEDURE FoodFactCoefficient_Merge (
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_c DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO FoodFactCoefficient USING ( VALUES (
v_FoodId,
v_NutrientId,
v_c
) ) ON (
FoodId = v_FoodId
AND
NutrientId = v_NutrientId
)
WHEN MATCHED THEN UPDATE SET
c = v_c
WHEN NOT MATCHED THEN INSERT VALUES
v_FoodId,
v_NutrientId,
v_c;
END;
/