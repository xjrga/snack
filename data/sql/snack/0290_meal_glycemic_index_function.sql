CREATE FUNCTION getMealGI (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE mealGI DOUBLE;
--
SET mealGI = 0;
--
SELECT MealGI INTO mealGI
FROM
(
SELECT a.mixid,
       'Total',
       sum(a.weight),
       sum(b.carbs),
       sum(CASE WHEN c.tcarbs <= 0 OR c.tcarbs IS NULL THEN 0 ELSE b.carbs / c.tcarbs END) AS Pct,
       sum(d.gl),
       sum(CASE WHEN c.tcarbs <= 0 OR c.tcarbs IS NULL THEN 0 ELSE b.carbs / c.tcarbs END *getGIFromGL(a.foodid)),
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
      AND   nutrientid = '10006') d
WHERE a.mixid = b.mixid
AND a.mixid = c.mixid
AND a.mixid = d.mixid
AND   a.foodid = b.foodid
AND a.foodid = d.foodid
GROUP BY a.mixid
);
--
RETURN mealGI;
--
END;
/
