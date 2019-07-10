CREATE PROCEDURE FoodCategory_Insert_2 (
--
IN v_Name VARCHAR(8000)
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
INSERT INTO FoodCategory (
FoodCategoryId,
Name
) VALUES (
generateId('c',''),
v_Name
);
--
END;
/