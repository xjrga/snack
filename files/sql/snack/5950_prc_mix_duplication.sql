CREATE PROCEDURE Mix_Duplicate (
--
OUT newid LONGVARCHAR,
--
IN v_MixId_Old LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
DECLARE v_MixId_New LONGVARCHAR;
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
CALL FoodNutrientConstraint_Copy(v_MixId_Old,v_MixId_New);
--
CALL FoodNutrientRatio_Copy(v_MixId_Old,v_MixId_New);
--
CALL DnMixResult_copy(v_MixId_Old,v_MixId_New);
--
CALL meal_copy(v_MixId_Old,v_MixId_New);
--
CALL meal_food_portion_copy(v_MixId_Old,v_MixId_New);
--
SET newid = v_MixId_New;
--
END;
/