CREATE PROCEDURE allocate (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
FOR SELECT mixid,foodid FROM mixfood WHERE mixid = v_MixId DO
FOR SELECT mealid FROM meal DO
CALL MealFoodAllocation_update_expectedwt(mixid,mealid, foodid);
END FOR;
END FOR;
--
END;
/
