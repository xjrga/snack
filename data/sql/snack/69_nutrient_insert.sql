CREATE PROCEDURE Nutrient_Insert (
IN v_NutrientId VARCHAR(8000),
IN v_Name VARCHAR(8000)
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Nutrient (
NutrientId,
Name
) VALUES (
v_NutrientId,
v_Name
);
END;
/
