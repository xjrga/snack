CREATE PROCEDURE dridev_tni_lhs (
--
IN v_mixid LONGVARCHAR,
--
IN v_nutrientid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT rownum() AS x,
       name,
       c
FROM (SELECT name, c
      FROM (SELECT a.foodid AS name,
                   b.c AS c
            FROM mixfood a,
                 foodfactcoefficient b
            WHERE mixid = v_mixid
            AND   b.nutrientid = v_nutrientid
            AND   a.foodid = b.foodid
            ORDER BY foodid)
      UNION ALL
      SELECT name, deficiency
      FROM (SELECT concat('deficiency_',nutrientid) AS name,
                   CASEWHEN(nutrientid = v_nutrientid,1.0,0) AS deficiency
            FROM tninutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT name, excess
      FROM (SELECT concat('excess_',nutrientid) AS name,
                   CASEWHEN(nutrientid = v_nutrientid,-1.0,0) AS excess
            FROM tninutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT 'avg_deficiency',
             0 AS avg_deficiency
      FROM (
           VALUES (0))
      UNION ALL
      SELECT 'avg_excess',
             0 AS avg_excess
      FROM (
           VALUES (0)));
--
OPEN result;
--
END;
/
