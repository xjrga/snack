CREATE PROCEDURE FoodCategory_Update (
--
IN v_FoodCategoryId VARCHAR(8000),
--
IN v_Name VARCHAR(8000)
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
UPDATE
FoodCategory
SET
Name = v_Name
WHERE
FoodCategoryId = v_FoodCategoryId;
--
END;
/