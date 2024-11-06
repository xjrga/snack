CREATE PROCEDURE Meal_insert (
IN v_MixId LONGVARCHAR,
IN v_Name LONGVARCHAR,
IN v_MealOrder INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Meal (
MixId,
Name,
MealOrder
) VALUES (
v_MixId,
v_Name,
v_MealOrder
);
END;
/