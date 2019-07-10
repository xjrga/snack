CREATE FUNCTION getFoodCoefficient(IN v_FoodId VARCHAR(8000),IN v_NutrientId VARCHAR(8000) ) RETURNS DOUBLE
READS SQL DATA BEGIN ATOMIC
DECLARE v_c DOUBLE;
select b.q/a.servingsize INTO v_c from food a, foodfact b where a.foodid = b.foodid and a.foodid = v_FoodId and b.nutrientid = v_NutrientId;
RETURN v_c;
END;
/
