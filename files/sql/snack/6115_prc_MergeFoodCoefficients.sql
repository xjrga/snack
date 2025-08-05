CREATE PROCEDURE MergeFoodCoefficients(
--
IN v_foodid LONGVARCHAR
--
)
--
MODIFIES SQL DATA
BEGIN ATOMIC
--
DECLARE v_c DECIMAL(28,18)
;
--
FOR SELECT nutrientid FROM nutrient DO
--
SET v_c = getFoodCoefficient(v_foodid,nutrientid);
--
call FoodFactCoefficient_Merge(v_foodid,nutrientid,v_c);
--
END FOR;
--
END;
/
