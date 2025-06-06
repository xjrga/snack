CREATE FUNCTION calculate_remaining_percentage (
IN v_MixId LONGVARCHAR,
IN v_FoodId LONGVARCHAR
) RETURNS DECIMAL(11,5)
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE v_c DECIMAL(11,5);
--
SELECT SUM(pct) INTO v_c FROM MealFoodPortion WHERE MixId = v_MixId AND FoodId = v_FoodId;
--
RETURN IFNULL(v_c,0.0) * 100;
--
END;
/
