CREATE PROCEDURE deleteAllFoods()
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM Food;
END;
/
