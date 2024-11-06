CREATE PROCEDURE getMixCoefficientsAll (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT b.foodid,
       b.nutrientid,
       getfoodcoefficient(b.foodid,b.nutrientid) AS c
FROM mixfood a,
     foodfactcoefficient b,
     nutrient c
WHERE a.foodid = b.foodid
AND   b.nutrientid = c.nutrientid
AND   a.mixid = v_mixid
ORDER BY b.foodid,
         b.nutrientid;
--
OPEN result;

--
END;
/
