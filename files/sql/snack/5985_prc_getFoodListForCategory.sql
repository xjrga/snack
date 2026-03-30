CREATE PROCEDURE getFoodListForCategory(
--
IN vFoodCategoryId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT a.foodid, a.name
FROM food a, categorylink b, foodcategory c
WHERE a.foodid = b.foodid
AND b.foodcategoryid = c.foodcategoryid
AND c.foodcategoryid = vFoodCategoryId
ORDER BY name;
--
OPEN result;
--
END;
/
