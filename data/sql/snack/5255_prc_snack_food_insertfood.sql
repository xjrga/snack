CREATE PROCEDURE snack_food_insertfood (IN v_foodid LONGVARCHAR,IN v_foodnom LONGVARCHAR)
--
modifies sql data BEGIN atomic
--
call food_insert(v_foodid,v_foodnom);
call FoodFact_ZeroOut_FoodId(v_foodid);
--
END;
/
