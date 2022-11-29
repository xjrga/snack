CREATE PROCEDURE MealFoodPortion_update_expectedwt (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_FoodId LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE MealFoodPortion
SET
ExpectedWt = (SELECT b.x*a.pct
                     FROM mealfoodportion a,
                          mixfood b
                     WHERE a.mixid = v_MixId
                     AND   a.mealid = v_MealId
                     AND  a.mixid = b.mixid
                     AND   a.foodid = b.foodid
                     AND   a.foodid = v_FoodId)
WHERE
MixId = v_MixId AND
MealId = v_MealId AND
FoodId = v_FoodId;
END;
/