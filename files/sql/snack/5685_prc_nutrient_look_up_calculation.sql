CREATE PROCEDURE Nutrient_Lookup_List (
--
IN v_nutrientid LONGVARCHAR,
IN v_q DECIMAL(25,18)

--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR FOR
SELECT b.foodid,
       b.name,
       a.weight,
       a.calories
FROM (SELECT a.foodid,
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
      WHERE a.foodid = b.foodid) a,
     food b
WHERE a.foodid = b.foodid
ORDER BY a.calories,b.name;
--
OPEN result;
--
END
/
