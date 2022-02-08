CREATE PROCEDURE Nutrient_Lookup_List (
--
IN v_nutrientid LONGVARCHAR,
IN v_q DOUBLE,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR FOR
SELECT a.name,
       ROUND(v_q / b.c,v_Precision) AS Weight
FROM food a,
     foodfactcoefficient b
WHERE a.foodid = b.foodid
AND   b.nutrientid = v_nutrientid
AND   b.c > 0
ORDER BY Weight;
--
OPEN result;

--
END
/