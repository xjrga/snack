CREATE FUNCTION getMealGI (IN v_MixId LONGVARCHAR) RETURNS DECIMAL(10,5)
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE mealGI DECIMAL(10,5);
--
SET mealGI = 0;
--
SELECT SUM(CASE WHEN tcarbs <= 0 OR tcarbs IS NULL THEN 0 ELSE carbs / tcarbs END * getGIFromGL (food_id)) INTO mealGI
FROM (SELECT mix_id,
             food_id,
             other_weight,
             carbohydrates_digestible AS carbs,
             (SELECT SUM(carbohydrates_digestible)
              FROM DnMixResult
              WHERE mix_id = v_MixId) AS tcarbs,
             carbohydrates_glycemic_load AS gl
      FROM DnMixResult
      WHERE mix_id = v_MixId)
GROUP BY mix_id;
--
RETURN mealGI;
--
END;
/
