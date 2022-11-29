CREATE PROCEDURE GlycemicIndex_merge (
IN v_FoodId LONGVARCHAR,
IN v_q DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
MERGE INTO GlycemicIndex USING ( VALUES (
v_FoodId,
v_q
) ) ON (
FoodId = v_FoodId
)
WHEN MATCHED THEN UPDATE SET
q = v_q
WHEN NOT MATCHED THEN INSERT VALUES
v_FoodId,
v_q;
END;
/