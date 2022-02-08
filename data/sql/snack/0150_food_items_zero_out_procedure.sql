CREATE PROCEDURE FoodFact_ZeroOut ()
--
modifies sql data BEGIN atomic
--
FOR SELECT foodid FROM food DO
--
FOR SELECT nutrientid FROM nutrient DO
--
call FoodFact_Merge (foodid,nutrientid,0);
--
END FOR;
--
END FOR;
--
END;
/