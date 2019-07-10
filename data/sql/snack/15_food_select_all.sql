CREATE PROCEDURE Food_Select_All ()
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT c.name AS category,
       a.foodid,
       b.name AS food
FROM categorylink a,
     food b,
     foodcategory c
WHERE a.foodid = b.foodid
AND   a.foodcategoryid = c.foodcategoryid
ORDER BY category,
         food;
--
OPEN result;
--
END;
/
