CREATE PROCEDURE CategoryLink_Delete (
--
IN v_FoodCategoryId LONGVARCHAR,
--
IN v_FoodId LONGVARCHAR
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
