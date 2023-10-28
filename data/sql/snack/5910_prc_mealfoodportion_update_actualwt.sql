CREATE PROCEDURE MealFoodPortion_update_actualwt (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_ActualWt DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE MealFoodPortion
SET
ActualWt = v_ActualWt
WHERE
MixId = v_MixId AND
MealId = v_MealId AND
FoodId = v_FoodId;
END;
/