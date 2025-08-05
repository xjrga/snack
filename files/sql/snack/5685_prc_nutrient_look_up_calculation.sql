CREATE PROCEDURE Nutrient_Lookup_List (
--
IN v_nutrientid LONGVARCHAR,
IN v_q DECIMAL(28,18)

--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR FOR
SELECT a.foodcategoryid as categoryid,
       b.foodid as foodid,
       a.name as category,
       b.name as food,
       a.calories,
       a.weight
FROM (SELECT b.name,
             b.foodcategoryid,
             a.foodid,
             a.weight,
             a.calories
      FROM (SELECT b.foodcategoryid,
                   b.foodid,
                   a.weight,
                   a.calories
            FROM (SELECT a.foodid,
                         a.q AS weight,
                         b.c*a.q AS calories
                  FROM (SELECT foodid,
                               v_q / c AS q
                        FROM (SELECT foodid,
                                     c
                              FROM foodfactcoefficient a
                              WHERE nutrientid = v_nutrientid
                              AND   c > 0)) a,
                       (SELECT foodid,
                               c
                        FROM foodfactcoefficient a
                        WHERE nutrientid = '10009') b
                  WHERE a.foodid = b.foodid) a,
                 CategoryLink b
            WHERE a.foodid = b.foodid) a,
           foodcategory b
      WHERE a.foodcategoryid = b.foodcategoryid) a,
     food b
WHERE a.foodid = b.foodid
ORDER BY a.name, a.calories;
--
OPEN result;
--
END
/
