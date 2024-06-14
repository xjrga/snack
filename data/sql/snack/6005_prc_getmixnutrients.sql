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
      FROM nutrientconstraint
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_1
      FROM nutrientratio
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_2
      FROM nutrientratio
      WHERE mixid = v_mixid
      UNION
      SELECT nutrientid
      FROM foodnutrientconstraint
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_1
      FROM foodnutrientratio
      WHERE mixid = v_mixid
      UNION
      SELECT nutrient_id_2
      FROM foodnutrientratio
      WHERE mixid = v_mixid)
ORDER BY nutrientid;
--
OPEN result;

--
END;
/
