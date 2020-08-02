CREATE PROCEDURE FoodCategory_Insert (
IN v_FoodCategoryId LONGVARCHAR,
IN v_Name LONGVARCHAR
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO FoodCategory (
FoodCategoryId,
Name
) VALUES (
v_FoodCategoryId,
v_Name
);
END;
/
