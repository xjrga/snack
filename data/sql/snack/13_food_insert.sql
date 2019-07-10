CREATE PROCEDURE Food_Insert (
IN v_FoodId VARCHAR(8000),
IN v_Name VARCHAR(8000),
IN v_ServingSize DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
INSERT INTO Food (
FoodId,
Name,
ServingSize
) VALUES (
v_FoodId,
v_Name,
v_ServingSize
);
END;
/
