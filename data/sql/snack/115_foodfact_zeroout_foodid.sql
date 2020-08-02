CREATE PROCEDURE FoodFact_ZeroOut_FoodId (
--
IN v_FoodId LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
FOR SELECT nutrientid FROM nutrient DO
--
call FoodFact_Insert (v_FoodId,nutrientid,0);
--
END FOR;
--
END;
/