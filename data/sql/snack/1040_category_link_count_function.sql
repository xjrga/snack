CREATE FUNCTION CategoryLink_Count (
--
IN v_FoodCategoryId LONGVARCHAR,
--
IN v_FoodId LONGVARCHAR
--
) RETURNS INTEGER
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_count INTEGER;

--
SELECT COUNT(*) INTO v_count
FROM CategoryLink
WHERE FoodCategoryId = v_FoodCategoryId
AND   FoodId = v_FoodId;
--
RETURN v_count;

--
END;
/