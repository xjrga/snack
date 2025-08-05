CREATE PROCEDURE FoodFact_insert (
--
IN v_FoodId LONGVARCHAR,
IN v_NutrientId LONGVARCHAR,
IN v_q DECIMAL(28,18)

--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
INSERT INTO FoodFact (
FoodId,
NutrientId,
q
) VALUES (
v_FoodId,
v_NutrientId,
v_q
);
--
END;
/
