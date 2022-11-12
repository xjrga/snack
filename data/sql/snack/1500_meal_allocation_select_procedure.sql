CREATE PROCEDURE MealFoodAllocation_select_all (
IN v_MixId LONGVARCHAR,
IN v_Precision INTEGER
)
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
SELECT MixId,
       c.MealId,
       b.FoodId,
       c.Name,
       b.Name,
       ROUND(a.Pct * 100,v_Precision),
       ROUND(a.ExpectedWt,v_Precision),
       ROUND(a.ActualWt,v_Precision),
       c.MealOrder
FROM MealFoodAllocation a,
     Food b, Meal c
WHERE a.foodid = b.foodid
AND a.mealid = c.mealid
AND   a.MixId = v_MixId
ORDER BY c.MealOrder,b.Name;
OPEN result;
END;
/