CREATE PROCEDURE Nutrient_Insert (
--
IN v_NutrientId LONGVARCHAR,
IN v_Name LONGVARCHAR,
IN v_NutrientCategoryId LONGVARCHAR,
IN v_Label LONGVARCHAR,
IN v_Units LONGVARCHAR,
IN v_Dri INTEGER,
IN v_Calculated INTEGER
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
INSERT INTO Nutrient (
NutrientId,
Name,
NutrientCategoryId,
Label,
Units,
Dri,
Calculated
) VALUES (
v_NutrientId,
v_Name,
v_NutrientCategoryId,
v_Label,
v_Units,
v_Dri,
v_Calculated
);
--
END;
/