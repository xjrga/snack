CREATE PROCEDURE deleteAllFoodCategories()
MODIFIES SQL DATA BEGIN ATOMIC
DELETE FROM FoodCategory;
END;
/
