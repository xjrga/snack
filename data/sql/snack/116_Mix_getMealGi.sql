CREATE PROCEDURE Mix_getMealGi (
--
IN v_MixId INTEGER,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT CASE
       WHEN b.name IS NULL THEN 'Total'
       ELSE b.name
       END as name,
       ROUND(a.weight,v_Precision) AS weight,
       ROUND(a.carbs,v_Precision) AS carbs,
       ROUND(a.pct*100,v_Precision) AS pct,
       ROUND(a.gl,v_Precision) AS gl,
       ROUND(a.gi,v_Precision) AS gi,
       ROUND(a.mealgi,v_Precision) AS mealgi
FROM
(
SELECT a.mixid,
       a.foodid,
       a.weight,
       b.carbs,
       CASE WHEN c.tcarbs <= 0 OR c.tcarbs IS NULL THEN 0 ELSE b.carbs / c.tcarbs END AS Pct,
       d.gl,
       getGIFromGL(a.foodid) as gi,
       CASE WHEN c.tcarbs <= 0 OR c.tcarbs IS NULL THEN 0 ELSE b.carbs / c.tcarbs END *getGIFromGL(a.foodid) AS MealGI
FROM (SELECT mixid,
             foodid,
             q AS weight
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10000') a,
     (SELECT mixid,
             foodid,
             q AS carbs
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10003') b,
     (SELECT mixid,
             SUM(q) AS tcarbs
             FROM mixresult
             WHERE mixid = v_MixId
             AND   nutrientid = '10003'
             GROUP BY mixid) c,
     (SELECT mixid,
             foodid,
             q AS gl
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10008') d
WHERE a.mixid = b.mixid
AND a.mixid = c.mixid
AND a.mixid = d.mixid
AND   a.foodid = b.foodid
AND a.foodid = d.foodid
--
UNION
--
SELECT a.mixid,
       'Total',
       sum(a.weight),
       sum(b.carbs),
       sum(CASE WHEN c.tcarbs <= 0 OR c.tcarbs IS NULL THEN 0 ELSE b.carbs / c.tcarbs END) AS Pct,
       sum(d.gl),
       sum(CASE WHEN c.tcarbs <= 0 OR c.tcarbs IS NULL THEN 0 ELSE b.carbs / c.tcarbs END *getGIFromGL(a.foodid)) AS MealGI,
       sum(CASE WHEN c.tcarbs <= 0 OR c.tcarbs IS NULL THEN 0 ELSE b.carbs / c.tcarbs END *getGIFromGL(a.foodid)) AS MealGI
FROM (SELECT mixid,
             foodid,
             q AS weight
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10000') a,
     (SELECT mixid,
             foodid,
             q AS carbs
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10003') b,
     (SELECT mixid,
             SUM(q) AS tcarbs
             FROM mixresult
             WHERE mixid = v_MixId
             AND   nutrientid = '10003'
             GROUP BY mixid) c,
     (SELECT mixid,
             foodid,
             q AS gl
      FROM mixresult
      WHERE mixid = v_MixId
      AND   nutrientid = '10008') d
WHERE a.mixid = b.mixid
AND a.mixid = c.mixid
AND a.mixid = d.mixid
AND   a.foodid = b.foodid
AND a.foodid = d.foodid
GROUP BY a.mixid
) a
--
LEFT JOIN
--
(
SELECT foodid,
       name
       FROM food
) b
ON a.foodid = b.foodid
ORDER BY weight,name;
--
OPEN result;
--
END;
/
