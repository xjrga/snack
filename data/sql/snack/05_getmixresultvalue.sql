CREATE FUNCTION getMixResultValue (
--
IN v_MixId INTEGER,
--
IN v_FoodId VARCHAR(8000),
--
IN v_NutrientId VARCHAR(8000)
--
)
--
RETURNS DOUBLE READS SQL DATA BEGIN ATOMIC
--
DECLARE v_c DOUBLE;

--
SELECT a.x * b.c INTO v_c       
FROM mixfood a,
     foodfactcoefficient b
WHERE a.foodid = b.foodid
AND a.mixid = v_MixId
AND a.foodid = v_FoodId
AND b.nutrientid = v_NutrientId;
--
RETURN v_c;

END;
/
