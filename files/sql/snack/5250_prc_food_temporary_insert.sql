CREATE PROCEDURE Food_Insert_Temp (OUT v_OutFoodId LONGVARCHAR,IN v_FoodNom LONGVARCHAR)
--
modifies sql data BEGIN atomic
--
DECLARE v_FoodId LONGVARCHAR;
--
SET v_FoodId = generateId();
SET v_OutFoodId = v_FoodId;
--
call Food_Insert(v_FoodId,v_FoodNom);
call CategoryLink_Insert(v_FoodId,'5000');
call FoodFact_ZeroOut_FoodId(v_FoodId);
--
END;
/