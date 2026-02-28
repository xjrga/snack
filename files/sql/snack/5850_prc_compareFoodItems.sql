CREATE PROCEDURE compareFoodItems (
--
IN v_food_a LONGVARCHAR,IN v_food_b LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT category,
       nutrient,
       food_a,
       food_b,
       diff
FROM (SELECT a.name AS category,
             b.name AS nutrient,
             b.food_a AS food_a,
             b.food_b AS food_b,
             b.diff AS diff
      FROM (SELECT nutrientcategoryid, name FROM nutrientcategory) A,
           (SELECT b.nutrientcategoryid,
                   b.nutrientid,
                   b.name,
                   a.food_a AS food_a,
                   a.food_b AS food_b,
                   a.diff AS diff
            FROM (SELECT a.nutrientid,
                         a.value AS food_a,
                         b.value AS food_b,
                         a.value - b.value AS diff
                  FROM (SELECT nutrientid,
                               q / get_foodfact(v_food_a,'10009') * 100 AS value
                        FROM foodfact
                        WHERE foodid = v_food_a) a,
                       (SELECT nutrientid,
                               q / get_foodfact(v_food_b,'10009') * 100 AS value
                        FROM foodfact
                        WHERE foodid = v_food_b) b
                  WHERE a.nutrientid = b.nutrientid) a,
                 (SELECT nutrientid, name, nutrientcategoryid FROM nutrient) b
            WHERE a.nutrientid = b.nutrientid) B
      WHERE a.nutrientcategoryid = b.nutrientcategoryid)
ORDER BY nutrient ASC;
--
OPEN RESULT;

--
END
/
