CREATE PROCEDURE dridev_foodquantity_lhs (
--
IN v_mixid LONGVARCHAR,
--
IN v_foodid LONGVARCHAR,
--
IN v_nutrientid LONGVARCHAR
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
FROM (
SELECT a.foodid as name, 
       IFNULL(b.c,0) AS c
FROM
(SELECT foodid
FROM mixfood
WHERE mixid = v_mixid) a
LEFT JOIN 
(SELECT foodid,
        c
FROM foodfactcoefficient a
WHERE nutrientid = v_nutrientid
AND foodid = v_foodid
ORDER BY foodid
) b
ON a.foodid = b.foodid
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
FROM (VALUES (0))
UNION ALL
SELECT 'avg_excess',
        0 AS avg_excess
FROM (VALUES (0)));
--
OPEN result;
--
END;
/
