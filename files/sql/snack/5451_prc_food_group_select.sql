CREATE PROCEDURE FoodGroup_Select_All (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT
GroupId,
Name 
FROM
MixFoodGroup
WHERE 
mixid = v_mixid
Order by Name;
--
OPEN result;
--
END;
/
