CREATE PROCEDURE percentnutrient_lhs (
--
IN v_mixid INTEGER,
--
IN v_foodid LONGVARCHAR,
--
IN v_nutrientid LONGVARCHAR,
--
IN v_b DOUBLE

)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT --a.mixid,
       a.foodid,
       --b.nutrientid,
       CASE
         WHEN a.foodid = v_foodid THEN b.c*(1.0-(v_b/100.0))
         ELSE -1.0*b.c*(v_b/100.0)
       END AS c
FROM mixfood a,
     foodfactcoefficient b
WHERE a.foodid = b.foodid
AND b.nutrientid = v_nutrientid
AND   a.mixid = v_mixid
ORDER BY a.foodid;
         ---b.nutrientid;
--	    
OPEN result;
--
END
/