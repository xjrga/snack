CREATE PROCEDURE CategoryLink_Insert (
IN v_FoodId VARCHAR(8000),
IN v_FoodCategoryId VARCHAR(8000)
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO CategoryLink (
FoodCategoryId,
FoodId
) VALUES (
v_FoodCategoryId,
v_FoodId
);
END;
/