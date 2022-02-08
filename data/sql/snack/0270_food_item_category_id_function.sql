CREATE FUNCTION getCategoryId (IN v_FoodId LONGVARCHAR) RETURNS LONGVARCHAR
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_FoodCategoryId LONGVARCHAR;
--
SELECT FoodCategoryId INTO v_FoodCategoryId
FROM CategoryLink
WHERE FoodId = v_FoodId;
--
RETURN v_FoodCategoryId;
--
END;
/