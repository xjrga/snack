CREATE PROCEDURE MealFoodPortion_select_all (
IN v_MixId LONGVARCHAR
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT MixId,
       c.MealId,
       b.FoodId,
       c.Name,
       b.Name,
       a.Pct * 100,
       a.ExpectedWt,
       a.ActualWt,
       c.MealOrder
FROM MealFoodPortion a,
     Food b, Meal c
WHERE a.foodid = b.foodid
AND a.mealid = c.mealid
AND a.mixid = c.mixid
AND   a.MixId = v_MixId
ORDER BY c.MealOrder,b.Name;
OPEN result;
END;
/