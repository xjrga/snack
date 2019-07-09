DROP PROCEDURE Food_Insert;
/

CREATE PROCEDURE Food_Insert (
IN v_FoodId VARCHAR(8000),
IN v_Name VARCHAR(8000),
IN v_FoodCategoryId VARCHAR(8000)
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Food (
FoodId,
Name,
FoodCategoryId
) VALUES (
v_FoodId,
v_Name,
v_FoodCategoryId
);
END;
/
