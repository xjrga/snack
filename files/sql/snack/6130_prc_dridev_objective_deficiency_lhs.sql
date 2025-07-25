CREATE PROCEDURE dridev_objective_deficiency_lhs (
--
IN v_mixid LONGVARCHAR
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
FROM (SELECT name,
             c
      FROM (SELECT foodid AS name,
                   0 AS c
            FROM mixfood
            WHERE mixid = v_mixid
            ORDER BY foodid)
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
             1 AS avg_deficiency
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
