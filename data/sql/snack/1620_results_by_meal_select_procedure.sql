CREATE PROCEDURE results_by_meal_select (IN v_MixId LONGVARCHAR,IN v_Precision INTEGER) 
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 
BEGIN ATOMIC 
DECLARE result CURSOR
FOR
--
SELECT a.name,
       ROUND(a.amt,v_Precision) AS weight,
       ROUND(b.amt,v_Precision) AS egross,
       ROUND(c.amt,v_Precision) AS edigest,
       ROUND(d.amt,v_Precision) AS efat,
       ROUND(e.amt,v_Precision) AS ecarbs,
       ROUND(m.amt,v_Precision) AS efatcarbs,
       ROUND(f.amt,v_Precision) AS eprotein,
       ROUND(g.amt,v_Precision) AS ealcohol,
       ROUND(h.amt,v_Precision) AS fat,
       ROUND(i.amt,v_Precision) AS carbs,
       ROUND(j.amt,v_Precision) AS protein,
       ROUND(k.amt,v_Precision) AS complete,
       ROUND(l.amt,v_Precision) AS alcohol,
       ROUND(n.amt,v_Precision) AS fiber,
       ROUND(o.amt,v_Precision) AS sodium,
       ROUND(p.amt,v_Precision) AS potassium
FROM
--
(SELECT a.name,
        a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10000'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) A,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '208'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) B,
     --     
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10009'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) C,
     --               
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10013'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) D,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10011'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) E,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10012'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) F,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10014'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) G,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '204'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) H,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10003'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) I,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '203'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) J,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10001'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) K,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '221'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) L,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10010'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) M,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '291'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) N,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '307'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) O,
     --
(SELECT a.mealorder,
        SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '306'
 GROUP BY a.Name,
          a.MealOrder,
          c.nutrientid
 ORDER BY a.MealOrder) P
--
WHERE a.mealorder = b.mealorder
AND   a.mealorder = c.mealorder
AND   a.mealorder = d.mealorder
AND   a.mealorder = e.mealorder
AND   a.mealorder = f.mealorder
AND   a.mealorder = g.mealorder
AND   a.mealorder = h.mealorder
AND   a.mealorder = i.mealorder
AND   a.mealorder = j.mealorder
AND   a.mealorder = k.mealorder
AND   a.mealorder = l.mealorder
AND   a.mealorder = m.mealorder
AND   a.mealorder = n.mealorder
AND   a.mealorder = o.mealorder
AND   a.mealorder = p.mealorder
--
UNION
--
SELECT 'Total' AS name,
       ROUND(a.amt,v_Precision) AS weight,
       ROUND(b.amt,v_Precision) AS egross,
       ROUND(c.amt,v_Precision) AS edigest,
       ROUND(d.amt,v_Precision) AS efat,
       ROUND(e.amt,v_Precision) AS ecarbs,
       ROUND(m.amt,v_Precision) AS efatcarbs,
       ROUND(f.amt,v_Precision) AS eprotein,
       ROUND(g.amt,v_Precision) AS ealcohol,
       ROUND(h.amt,v_Precision) AS fat,
       ROUND(i.amt,v_Precision) AS carbs,
       ROUND(j.amt,v_Precision) AS protein,
       ROUND(k.amt,v_Precision) AS complete,
       ROUND(l.amt,v_Precision) AS alcohol,
       ROUND(n.amt,v_Precision) AS fiber,
       ROUND(o.amt,v_Precision) AS sodium,
       ROUND(p.amt,v_Precision) AS potassium
FROM
--
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10000') A,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '208') B,
     --     
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10009') C,
     --               
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10013') D,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10011') E,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10012') F,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10014') G,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '204') H,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10003') I,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '203') J,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10001') K,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '221') L,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '10010') M,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '291') N,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '307') O,
     --
(SELECT SUM(b.expectedwt*c.c) AS amt
 FROM meal a,
      mealfoodportion b,
      foodfactcoefficient c
 WHERE a.mixid = b.mixid
 AND   a.mealid = b.mealid
 AND   a.mixid = v_MixId
 AND   b.foodid = c.foodid
 AND   c.nutrientid = '306') P;
--
OPEN result;
--
END;
/
