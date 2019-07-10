CREATE PROCEDURE Food_Exchange_List (
--
IN v_nutrientid VARCHAR(8000),
--
IN v_q DOUBLE
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR FOR
SELECT a.name,
       ROUND(v_q / b.c) AS Quantity
FROM food a,
     foodfactcoefficient b
WHERE a.foodid = b.foodid
AND   b.nutrientid = v_nutrientid
AND   b.c > 0
ORDER BY quantity;
--
OPEN result;

--
END
/