CREATE FUNCTION countFood(
--
IN v_FoodId LONGVARCHAR
--
) RETURNS INTEGER
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE v_count INTEGER;
--
SELECT COUNT(1) INTO v_count
FROM food
WHERE foodid = v_FoodId;
--
RETURN v_count;
--
END;
/
