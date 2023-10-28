CREATE FUNCTION getMealGI (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE mealGI DOUBLE;
--
SET mealGI = 0;
--
SELECT SUM(CASE WHEN tcarbs <= 0 OR tcarbs IS NULL THEN 0 ELSE carbs / tcarbs END * getGIFromGL (foodid)) INTO mealGI
FROM (SELECT mixid,
             foodid,
             weight,
             digestiblecarbohydrate AS carbs,
             (SELECT SUM(digestiblecarbohydrate)
              FROM mixresultdn
              WHERE mixid = v_MixId) AS tcarbs,
             glycemicload AS gl
      FROM mixresultdn
      WHERE mixid = v_MixId)
GROUP BY mixid;
--
RETURN mealGI;
--
END;
/
