CREATE PROCEDURE Select_meal_food_portion_as_xml (
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
SET doc = CHAR(10) + '<meal_food_portion_list>' + CHAR(10) ;
--
FOR SELECT mixid, mealid, foodid, pct, expectedwt, actualwt FROM mealfoodportion WHERE mixid = v_MixId ORDER BY mealid, foodid DO
--
SET doc = doc +  '<meal_food_portion>' + CHAR (10) + '<mix-id>' + mixid + '</mix-id>' + CHAR (10) + '<meal-id>' + mealid + '</meal-id>' + CHAR (10) + '<food-id>' + foodid + '</food-id>' + CHAR (10) + '<pct>' + pct + '</pct>' + CHAR (10) + '<expected-wt>' + expectedwt + '</expected-wt>' + CHAR (10) + '<actual-wt>' + actualwt + '</actual-wt>'  + CHAR (10) + '</meal_food_portion>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</meal_food_portion_list>';
--
SET v_doc = doc;
--
END
/