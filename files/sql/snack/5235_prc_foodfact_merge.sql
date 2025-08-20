CREATE PROCEDURE FoodFact_Merge (
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_q DECIMAL(25,18)

)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO FoodFact USING ( VALUES (
v_FoodId,
v_NutrientId,
v_q
) ) ON (
FoodId = v_FoodId
AND
NutrientId = v_NutrientId
)
WHEN MATCHED THEN UPDATE SET
q = v_q
WHEN NOT MATCHED THEN INSERT VALUES
v_FoodId,
v_NutrientId,
v_q;
END;
/
