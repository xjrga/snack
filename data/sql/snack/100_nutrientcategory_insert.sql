CREATE PROCEDURE NutrientCategory_Insert (
IN v_NutrientCategoryId LONGVARCHAR,
IN v_Name LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO NutrientCategory (
NutrientCategoryId,
Name
) VALUES (
v_NutrientCategoryId,
v_Name
);
END;
/
