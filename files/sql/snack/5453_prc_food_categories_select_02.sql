CREATE PROCEDURE FoodCategory_Select (
--
IN v_foodid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT b.foodcategoryid,
       a.name
FROM FoodCategory a,
     CategoryLink b
WHERE a.foodcategoryid = b.foodcategoryid
AND   foodid = v_foodid;
--
OPEN result;
--
END;
/
