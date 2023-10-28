CREATE PROCEDURE Meal_select_all 
(
  IN V_MixId LONGVARCHAR
) 
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 
BEGIN ATOMIC 
DECLARE result CURSOR
FOR
SELECT MixId,
       MealId,
       Name,       
       MealOrder
FROM Meal
WHERE MixId = V_MixId
ORDER BY MealOrder;

OPEN result;

END;
/