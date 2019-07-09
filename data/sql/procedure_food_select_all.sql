DROP PROCEDURE Food_Select_All;
/
CREATE PROCEDURE Food_Select_All ()
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
DECLARE result CURSOR
FOR
select b.name as category,a.name as food
from food a, foodcategory b
where a.foodcategoryid = b.foodcategoryid;
OPEN result;
END;
/
