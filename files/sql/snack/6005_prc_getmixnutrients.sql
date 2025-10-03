CREATE PROCEDURE getMixNutrients (
--
IN v_mixid LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
--
SELECT DISTINCT nutrientid
FROM (SELECT nutrientid
      FROM NutrientQuantityC
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_1
      FROM NutrientRatioC
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_2
      FROM NutrientRatioC
      WHERE mixid = v_mixid
      UNION
      SELECT nutrientid
      FROM FoodQuantityC
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_1
      FROM FoodRatioC
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_2
      FROM FoodRatioC
      WHERE mixid = v_mixid)
ORDER BY nutrientid;
--
OPEN result;

--
END;
/
