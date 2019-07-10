CREATE PROCEDURE FoodFact_Insert (
IN v_FoodId VARCHAR(8000),
IN v_NutrientId VARCHAR(8000),
IN v_q DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO FoodFact (
FoodId,
NutrientId,
q
) VALUES (
v_FoodId,
v_NutrientId,
v_q
);
END;
/
