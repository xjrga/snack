DROP PROCEDURE FoodCategory_Insert;
/

CREATE PROCEDURE FoodCategory_Insert (
IN v_FoodCategoryId VARCHAR(8000),
IN v_Name VARCHAR(8000)
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
