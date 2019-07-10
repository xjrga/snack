CREATE PROCEDURE CategoryLink_Delete (
--
IN v_FoodCategoryId VARCHAR(8000),
--
IN v_FoodId VARCHAR(8000)
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DELETE FROM
CategoryLink
WHERE
FoodCategoryId = v_FoodCategoryId
AND
FoodId = v_FoodId;
--
END;
/
