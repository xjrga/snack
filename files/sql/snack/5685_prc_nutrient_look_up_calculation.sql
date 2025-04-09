CREATE PROCEDURE Nutrient_Lookup_List (
--
IN v_nutrientid LONGVARCHAR,
IN v_q DECIMAL(10,5)
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR FOR
SELECT getFoodName(a.foodid) as food,
       a.weight,
       a.weight*b.c AS calories
FROM (SELECT foodid,
             CASEWHEN(c <= 0.0,0.0,v_q / c) AS weight
      FROM foodfactcoefficient
      WHERE nutrientid = v_nutrientid) a,
     (SELECT foodid,
             c
      FROM foodfactcoefficient
      WHERE nutrientid = '10009'
      AND   c >= 0) b
WHERE a.foodid = b.foodid
AND a.weight > 0
ORDER BY calories ASC;
--
OPEN result;
--
END
/
