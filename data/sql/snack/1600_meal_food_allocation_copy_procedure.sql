CREATE PROCEDURE meal_food_allocation_copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO mealfoodallocation
(
  mixid,
  mealid,  
  foodid,
  pct,
  expectedwt,
  actualwt
)
SELECT v_MixId_New,
       mealid,  
       foodid,
       pct,
       expectedwt,
       actualwt
FROM mealfoodallocation
WHERE mixid = v_MixId_Old;
--
END;
/

