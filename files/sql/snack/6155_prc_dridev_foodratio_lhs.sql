CREATE PROCEDURE dridev_foodratio_lhs (
--
IN v_mixid LONGVARCHAR,
--
IN v_foodid1 LONGVARCHAR,
--
IN v_nutrientid1 LONGVARCHAR,
--
IN v_a DECIMAL,
--
IN v_foodid2 LONGVARCHAR,
--
IN v_nutrientid2 LONGVARCHAR,
--
IN v_b DECIMAL
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT rownum() AS x,
       name,
       c
FROM (SELECT foodid AS name,
             CASE
               WHEN foodid = v_foodid1 THEN (SELECT c
                                             FROM foodfactcoefficient
                                             WHERE foodid = v_foodid1
                                             AND   nutrientid = v_nutrientid1)
               ELSE 0
             END * v_b -
             CASE
               WHEN foodid = v_foodid2 THEN (SELECT c
                                             FROM foodfactcoefficient
                                             WHERE foodid = v_foodid2
                                             AND   nutrientid = v_nutrientid2)
               ELSE 0
             END * v_a AS c
      FROM mixfood
      WHERE mixid = v_mixid
      UNION ALL
      SELECT name,
             deficiency
      FROM (SELECT concat('deficiency_',nutrientid) AS name,
                   0 AS deficiency
            FROM tninutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT name,
             excess
      FROM (SELECT concat('excess_',nutrientid) AS name,
                   0 AS excess
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