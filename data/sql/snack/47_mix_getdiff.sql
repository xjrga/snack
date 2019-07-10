CREATE PROCEDURE Mix_getDiff (
--
IN v_MixId_1 INTEGER,
--
IN v_MixId_2 INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT b.name,
       round(a.mix1),
       round(a.mix2),
       round(a.diff)
FROM (SELECT a.nutrientid,
             a.value AS mix1,
             b.value AS mix2,
             a.value - b.value AS diff
      FROM (SELECT nutrientid,
                   SUM(a.x*b.c) AS value
            FROM mixfood a,
                 foodfactcoefficient b
            WHERE a.foodid = b.foodid
            AND   a.mixid = v_MixId_1
            GROUP BY nutrientid) a,
           (SELECT nutrientid,
                   SUM(a.x*b.c) AS value
            FROM mixfood a,
                 foodfactcoefficient b
            WHERE a.foodid = b.foodid
            AND   a.mixid = v_MixId_2
            GROUP BY nutrientid) b
      WHERE a.nutrientid = b.nutrientid) a,
     (SELECT nutrientid, name FROM nutrient) b
WHERE a.nutrientid = b.nutrientid
ORDER BY a.nutrientid;
--
OPEN result;
--
END;
/