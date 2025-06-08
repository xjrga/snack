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
SELECT a.name AS food,
       b.weight,
       b.calories
FROM food a,
     (SELECT a.foodid,
             a.q AS weight,
             b.c*a.q AS calories
      FROM (SELECT foodid,
                   v_q / c AS q
            FROM (SELECT foodid,
                         c
                  FROM foodfactcoefficient a
                  WHERE nutrientid = v_nutrientid
                  AND   c > 0)) a,
           (SELECT foodid,
                   c
            FROM foodfactcoefficient a
            WHERE nutrientid = '10009') b
      WHERE a.foodid = b.foodid) b
WHERE a.foodid = b.foodid
ORDER BY weight ASC;
--
OPEN result;
--
END
/
