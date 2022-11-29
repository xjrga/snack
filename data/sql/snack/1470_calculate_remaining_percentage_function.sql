CREATE FUNCTION calculate_remaining_percentage (
IN v_MixId LONGVARCHAR,
IN v_FoodId LONGVARCHAR,
IN v_Precision INTEGER) RETURNS DOUBLE 
--
READS SQL DATA 
BEGIN ATOMIC 
DECLARE v_c DOUBLE;
--
IF
--
(SELECT COUNT(*)
FROM MealFoodPortion a
WHERE a.mixid = v_MixId AND a.foodid = V_FoodId) = 0
--
THEN
--
SET v_c = 1;
--
ELSE
--
SELECT CASE
         WHEN SUM(pct) > 1 THEN 1 -SUM(pct)
         ELSE 1 -SUM(pct)
       END 
INTO v_c
FROM MealFoodPortion
WHERE MixId = v_MixId
AND   FoodId = v_FoodId;
--
END IF;
--
RETURN ROUND(v_c * 100,v_Precision);
--
END;
/
