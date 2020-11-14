CREATE PROCEDURE FoodCategory_Select_All ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT
FoodCategoryId,
Name 
FROM
FoodCategory
Order by Name;
--
OPEN result;
--
END;
/
