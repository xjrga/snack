CREATE PROCEDURE Mix_getMealGi (
--
IN v_MixId LONGVARCHAR,
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
       ROUND(a.weight, v_Precision) AS weight,
       ROUND(a.carbs, v_Precision) AS carbs,
       ROUND(a.pct*100, v_Precision) AS pct,
       ROUND(a.gl, v_Precision) AS gl,
       ROUND(a.gi, v_Precision) AS gi,
       ROUND(a.mealgi, v_Precision) AS mealgi
FROM
(
SELECT mixid,
       foodid,
       weight,
       carbs,
       CASE WHEN tcarbs <= 0 OR tcarbs IS NULL THEN 0 ELSE carbs / tcarbs END AS Pct,
       gl,
       getGIFromGL(foodid) as gi,
       CASE WHEN tcarbs <= 0 OR tcarbs IS NULL THEN 0 ELSE carbs / tcarbs END *getGIFromGL(foodid) AS MealGI
FROM (
SELECT mixid,
       foodid,
       weight,
       digestiblecarbohydrate AS carbs,
       (SELECT SUM(digestiblecarbohydrate)
        FROM mixresultdn
        WHERE mixid = v_MixId) AS tcarbs,
       glycemicload AS gl
FROM mixresultdn
WHERE mixid = v_MixId
)
--
UNION
--
SELECT mixid,
       'Total',
       sum(weight),
       sum(carbs),
       sum(CASE WHEN tcarbs <= 0 OR tcarbs IS NULL THEN 0 ELSE carbs / tcarbs END) AS Pct,
       sum(gl),
       sum(CASE WHEN tcarbs <= 0 OR tcarbs IS NULL THEN 0 ELSE carbs / tcarbs END *getGIFromGL(foodid)) AS MealGI,
       sum(CASE WHEN tcarbs <= 0 OR tcarbs IS NULL THEN 0 ELSE carbs / tcarbs END *getGIFromGL(foodid)) AS MealGI
FROM
(
SELECT mixid,
       foodid,
       weight,
       digestiblecarbohydrate AS carbs,
       (SELECT SUM(digestiblecarbohydrate)
        FROM mixresultdn
        WHERE mixid = v_MixId) AS tcarbs,
       glycemicload AS gl
FROM mixresultdn
WHERE mixid = v_MixId
)
GROUP BY mixid
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
