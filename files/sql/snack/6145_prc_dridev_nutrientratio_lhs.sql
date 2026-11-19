CREATE PROCEDURE dridev_nutrientratio_lhs (
--
IN v_mixid LONGVARCHAR,
--
IN v_nutrientid1 LONGVARCHAR,
--
IN v_nutrientid2 LONGVARCHAR,
--
IN v_a DECIMAL(25,18),
--
IN v_b DECIMAL(25,18)
--
)
--
MODIFIES sql data dynamic RESULT sets 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT rownum() AS x,
       name,
       c
FROM (SELECT a.foodid AS name,
             a.c*v_b - b.c*v_a AS c
      FROM (SELECT a.mixid,
                   a.foodid,
                   b.nutrientid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b
            WHERE a.foodid = b.foodid
            AND   a.mixid = v_mixid
            AND   b.nutrientid = v_nutrientid1) a,
           (SELECT a.mixid,
                   a.foodid,
                   b.nutrientid,
                   b.c
            FROM mixfood a,
                 foodfactcoefficient b
            WHERE a.foodid = b.foodid
            AND   a.mixid = v_mixid
            AND   b.nutrientid = v_nutrientid2) b
      WHERE a.foodid = b.foodid
      UNION ALL
      SELECT name,
             deficiency
      FROM (SELECT concat('deficiency_', nutrientid) AS name,
                   0 AS deficiency
            FROM balancednutrients
            ORDER BY nutrientid)
      UNION ALL
      SELECT name,
             excess
      FROM (SELECT concat('excess_', nutrientid) AS name,
                   0 AS excess
            FROM balancednutrients
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
