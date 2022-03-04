CREATE PROCEDURE snack_food_insertfood_and_categorizefood (IN v_foodid LONGVARCHAR,IN v_foodnom LONGVARCHAR)
--
modifies sql data BEGIN atomic
--
call food_insert(v_foodid,v_foodnom);
call categorylink_insert(v_foodid,'5000');
call FoodFact_ZeroOut_FoodId(v_foodid);
--
END;
/
