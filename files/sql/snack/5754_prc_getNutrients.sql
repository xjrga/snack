CREATE PROCEDURE getNutrients()
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT a.foodid,
       a.nutrientid,
       c.name AS food,
       b.name AS nutrient,
       a.q,
       b.units,
       b.dri
FROM foodfact a,
     nutrient b,
     food c
WHERE a.nutrientid = b.nutrientid
AND   a.foodid = c.foodid
ORDER BY a.foodid,
         b.dri DESC,
         b.name;
--
OPEN result;
--
END;
/
