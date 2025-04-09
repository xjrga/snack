CREATE PROCEDURE Meal_insert_02 (
IN v_MixId LONGVARCHAR,
--TODO - Fix, should be integer
IN v_MealId LONGVARCHAR,
IN v_Name LONGVARCHAR,
IN v_MealOrder INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Meal (
MixId,
MealId,
Name,
MealOrder
) VALUES (
v_MixId,
v_MealId,
v_Name,
v_MealOrder
);
END;
/