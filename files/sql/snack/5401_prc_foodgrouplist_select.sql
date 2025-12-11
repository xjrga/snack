CREATE PROCEDURE FoodGroupList_Select (
--
IN v_mixid LONGVARCHAR,
--
IN v_groupid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT
--
b.foodid,
b.name
--
FROM
--
FoodGroupList a,
Food b
--
WHERE 
--
a.mixid = v_mixid AND
a.groupid = v_groupid AND
a.foodid = b.foodid
--
ORDER BY b.name;
--
OPEN result;
--
END;
/