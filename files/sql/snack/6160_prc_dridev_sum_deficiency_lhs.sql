CREATE PROCEDURE dridev_sum_deficiency_lhs (
--
IN v_mixid LONGVARCHAR,
--
IN v_lifestageid INTEGER
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
                   0 AS c
            FROM mixfood a
            WHERE mixid = v_mixid
            ORDER BY foodid)
      UNION ALL
      SELECT name, deficiency
      FROM (SELECT concat('deficiency_',nutrientid) as name,
                   b.cq AS deficiency
            FROM tninutrients a,
                 rdacoefficients b
            WHERE a.nutrientid = b.nutrientid
            AND   b.lifestageid = v_lifestageid
            ORDER BY nutrientid)
      UNION ALL
      SELECT name, excess
      FROM (SELECT concat('excess_',nutrientid) as name,
                   0 AS excess
            FROM tninutrients a
            ORDER BY nutrientid)
      UNION ALL
      SELECT 'avg_deficiency',
             -8 AS avg_deficiency
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
