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
       ROUND(a.weight*b.c,v_Precision) AS calories,
       ROUND(a.weight,v_Precision) AS weight
FROM (SELECT a.name,
             a.foodid,
             v_q / b.c AS weight
      FROM food a,
           foodfactcoefficient b
      WHERE a.foodid = b.foodid
      AND   b.nutrientid = v_nutrientid
      AND   b.c > 0) a,
     (SELECT foodid,
             c
      FROM foodfactcoefficient
      WHERE nutrientid = '10009'
      AND   c > 0) b
WHERE a.foodid = b.foodid
ORDER BY calories,weight;
--
OPEN result;
--
END
/