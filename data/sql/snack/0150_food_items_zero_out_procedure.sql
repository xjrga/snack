CREATE PROCEDURE FoodFact_ZeroOut ()
--
modifies sql data BEGIN atomic
--
FOR SELECT foodid FROM food DO
--
call FoodFact_ZeroOut_FoodId(foodid);
--
END FOR;
--
END;
/