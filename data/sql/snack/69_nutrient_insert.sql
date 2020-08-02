CREATE PROCEDURE Nutrient_Insert (
IN v_NutrientId LONGVARCHAR,
IN v_Name LONGVARCHAR,
IN v_NutrientCategoryId LONGVARCHAR,
IN v_Label LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Nutrient (
NutrientId,
Name,
NutrientCategoryId,
Label
) VALUES (
v_NutrientId,
v_Name,
v_NutrientCategoryId,
v_Label
);
END;
/