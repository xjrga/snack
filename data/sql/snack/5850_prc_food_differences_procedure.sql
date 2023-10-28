CREATE PROCEDURE food_differences_procedure (
--
IN v_food_a LONGVARCHAR,
IN v_food_b LONGVARCHAR,
IN v_precision INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT a.name,b.name,b.food_a,b.food_b,b.diff
FROM
(
SELECT nutrientcategoryid, name
FROM nutrientcategory) A,
(
SELECT
       b.nutrientcategoryid,
       b.nutrientid,
       b.name,
       round(a.food_a,5) as food_a,
       round(a.food_b,5) as food_b,
       round(a.diff,5) as diff
FROM (SELECT a.nutrientid,
             a.value AS food_a,
             b.value AS food_b,
             b.value - a.value AS diff
      FROM (SELECT nutrientid,
                   c * 100 AS value
            FROM foodfactcoefficient
            WHERE foodid = v_food_a
            ) a,
           (SELECT nutrientid,
                   c * 100 AS value
            FROM foodfactcoefficient
            WHERE foodid = v_food_b
            ) b
      WHERE a.nutrientid = b.nutrientid) a,
     (SELECT nutrientid, name, nutrientcategoryid FROM nutrient) b
WHERE a.nutrientid = b.nutrientid) B
WHERE a.nutrientcategoryid = b.nutrientcategoryid
ORDER BY a.name, b.name;
--
OPEN result;
--
END;
/
