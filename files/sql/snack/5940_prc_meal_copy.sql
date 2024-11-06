CREATE PROCEDURE meal_copy (
--
IN v_MixId_Old LONGVARCHAR,
--
IN v_MixId_New LONGVARCHAR
--
)
--
modifies sql data BEGIN atomic
--
INSERT INTO meal
(
  mixid,
  mealid,  
  name,
  mealorder
)
SELECT v_MixId_New,
       mealid,  
       name,
       mealorder
FROM Meal
WHERE mixid = v_MixId_Old;
--
END;
/

