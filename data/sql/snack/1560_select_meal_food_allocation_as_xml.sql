CREATE PROCEDURE Select_meal_food_allocation_as_xml (
--
OUT v_doc LONGVARCHAR,
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA
--
BEGIN ATOMIC 
--
DECLARE doc LONGVARCHAR;
--
SET doc = CHAR(10) + '<meal_food_allocation_list>' + CHAR(10) ;
--
FOR SELECT mixid, mealid, foodid, pct, expectedwt, actualwt FROM mealfoodallocation WHERE mixid = v_MixId ORDER BY mealid, foodid DO
--
SET doc = doc +  '<meal_food_allocation>' + CHAR (10) + '<mixid>' + mixid + '</mixid>' + CHAR (10) + '<mealid>' + mealid + '</mealid>' + CHAR (10) + '<foodid>' + foodid + '</foodid>' + CHAR (10) + '<pct>' + pct + '</pct>' + CHAR (10) + '<expectedwt>' + expectedwt + '</expectedwt>' + CHAR (10) + '<actualwt>' + actualwt + '</actualwt>'  + CHAR (10) + '</meal_food_allocation>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</meal_food_allocation_list>';
--
SET v_doc = doc;
--
END
/