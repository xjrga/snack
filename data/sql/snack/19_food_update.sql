CREATE PROCEDURE Food_Update (
IN v_FoodId VARCHAR(8000),
IN v_Name VARCHAR(8000),
IN v_ServingSize DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
UPDATE
Food
SET
Name = v_Name,
ServingSize = v_ServingSize
WHERE
FoodId = v_FoodId;
END;
/