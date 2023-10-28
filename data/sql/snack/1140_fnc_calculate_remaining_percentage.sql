CREATE FUNCTION calculate_remaining_percentage (
IN v_MixId LONGVARCHAR,
IN v_FoodId LONGVARCHAR,
IN v_Precision INTEGER) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE v_c DOUBLE;
--
SELECT SUM(pct) INTO v_c FROM MealFoodPortion WHERE MixId = v_MixId AND FoodId = v_FoodId;
--
RETURN ROUND(v_c * 100,v_Precision);
--
END;
/
