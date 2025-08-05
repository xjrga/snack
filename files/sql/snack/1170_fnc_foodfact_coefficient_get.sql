CREATE FUNCTION getFoodCoefficient(IN v_FoodId LONGVARCHAR,IN v_NutrientId LONGVARCHAR ) RETURNS DOUBLE
READS SQL DATA BEGIN ATOMIC
DECLARE v_c DECIMAL(24,18)
;
SELECT CASE WHEN a.q > 0 THEN b.q / a.q ELSE 0 END INTO v_c
FROM (SELECT foodid,
             q
      FROM foodfact
      WHERE foodid = v_FoodId
      --Check Weight "serving size" is inserted before other nutrientids
      AND   nutrientid = '10000') a,
     foodfact b
WHERE a.foodid = b.foodid
AND   a.foodid = v_FoodId
AND   b.nutrientid = v_NutrientId;
RETURN v_c;
END;
/
