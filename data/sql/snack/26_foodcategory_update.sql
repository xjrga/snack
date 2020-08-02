CREATE PROCEDURE FoodCategory_Update (
--
IN v_FoodCategoryId LONGVARCHAR,
--
IN v_Name LONGVARCHAR
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