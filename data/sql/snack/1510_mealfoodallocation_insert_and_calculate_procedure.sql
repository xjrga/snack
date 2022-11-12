CREATE PROCEDURE MealFoodAllocation_insert_and_calculate (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_Pct DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
DECLARE v_Pct_d DOUBLE;
SET v_Pct_d = v_Pct/100;
CALL MealFoodAllocation_merge_01(v_MixId,v_MealId,v_FoodId,v_Pct_d,null,0);
CALL MealFoodAllocation_update_expectedwt(v_MixId,v_MealId,v_FoodId);
END;
/

CREATE PROCEDURE MealFoodAllocation_insert_and_calculate_01 (
IN v_MixId LONGVARCHAR,
IN v_MealId INTEGER,
IN v_FoodId LONGVARCHAR,
IN v_Pct DOUBLE
)
MODIFIES SQL DATA BEGIN ATOMIC
DECLARE v_Pct_d DOUBLE;
SET v_Pct_d = v_Pct/100;
CALL MealFoodAllocation_update_pct(v_MixId,v_MealId,v_FoodId,v_Pct_d);
CALL MealFoodAllocation_update_expectedwt(v_MixId,v_MealId,v_FoodId);
END;
/