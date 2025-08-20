--Compare Two 100 Kcal servings
CREATE PROCEDURE compareFoodItems (
--
IN v_food_a LONGVARCHAR,
IN v_food_b LONGVARCHAR
--
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
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
       a.food_a as food_a,
       a.food_b as food_b,
       a.diff as diff
FROM (
--
SELECT a.nutrientid,
       a.value AS food_a,
       b.value AS food_b,
       a.value - b.value AS diff
FROM (SELECT nutrientid, CASE WHEN get_foodfact(v_food_a,'10009') <= 0 THEN 0 ELSE q / get_foodfact(v_food_a,'10009') * 100 END AS value
      FROM foodfact
      WHERE foodid = v_food_a) a,
     (SELECT nutrientid, CASE WHEN get_foodfact(v_food_b,'10009') <= 0 THEN 0 ELSE q / get_foodfact(v_food_b,'10009') * 100 END AS value
      FROM foodfact
      WHERE foodid = v_food_b) b
WHERE a.nutrientid = b.nutrientid
--
) a,
(SELECT nutrientid, name, nutrientcategoryid FROM nutrient) b
WHERE a.nutrientid = b.nutrientid) B
WHERE a.nutrientcategoryid = b.nutrientcategoryid
ORDER BY a.name, b.name;
--
OPEN result;
--
END;
/
