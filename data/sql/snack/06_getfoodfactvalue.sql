CREATE FUNCTION getFoodFactValue (IN v_FoodId VARCHAR(8000),IN v_NutrientId VARCHAR(8000)) RETURNS DOUBLE 
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_q DOUBLE;
--
SELECT a.q INTO v_q
FROM foodfact a
WHERE a.foodid = v_FoodId
AND   a.nutrientid = v_NutrientId;
--
RETURN v_q;
--
END;
/
