CREATE PROCEDURE Meal_update (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_Name LONGVARCHAR,
IN v_MealOrder INTEGER
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE Meal
SET
Name = v_Name,
MealOrder = v_MealOrder
WHERE
MixId = v_MixId AND
MealId = v_MealId;
END;
/