CREATE PROCEDURE Mix_Duplicate (
--
IN v_MixId_Old INTEGER
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_MixId_New INTEGER;
--
call mix_copy(v_MixId_New,v_MixId_Old);
--
call mixfood_copy(v_MixId_Old,v_MixId_New);
--
CALL MixResult_Copy(v_MixId_Old,v_MixId_New);
--
CALL NutrientConstraint_Copy(v_MixId_Old,v_MixId_New);
--
CALL NutrientRatio_Copy(v_MixId_Old,v_MixId_New);
--
CALL FoodNutrientConstraint(v_MixId_Old,v_MixId_New);
--
CALL FoodNutrientRatio(v_MixId_Old,v_MixId_New);
--
END;
/