CREATE PROCEDURE FoodCategory_Delete (
--
IN v_FoodCategoryId VARCHAR(8000)
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DELETE FROM
FoodCategory
WHERE
FoodCategoryId = v_FoodCategoryId;
--
END;
/