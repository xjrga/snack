CREATE PROCEDURE Select_foodnutrient_ratio_constraint_list_as_xml (
--
OUT v_doc LONGVARCHAR,
--
IN v_mixid LONGVARCHAR
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC 
--
DECLARE doc LONGVARCHAR;
--
DECLARE counter INTEGER;
--
SET doc = '';
--
SET counter = 0;
--
SELECT count(food_id_1, nutrient_id_1,food_id_2, nutrient_id_2,relationshipid, a, b) INTO counter FROM FoodRatioC WHERE mixid = v_mixid;
--
IF counter > 0 THEN
--
SET doc = doc + '<food_ratio_list>' + CHAR (10);
--
FOR select food_id_1, nutrient_id_1,food_id_2, nutrient_id_2,relationshipid, a, b from FoodRatioC WHERE mixid = v_mixid DO
--
SET doc = doc + '<food_ratio>' + CHAR (10) + '<food-id_a>' + food_id_1 + '</food-id_a>' + CHAR (10) + '<nutrient-id_a>' + nutrient_id_1 + '</nutrient-id_a>' + CHAR (10) + '<food-id_b>' + food_id_2 + '</food-id_b>' + CHAR (10) + '<nutrient-id_b>' + nutrient_id_2 + '</nutrient-id_b>' + CHAR (10) + '<relationship-id>' + relationshipid  + '</relationship-id>' + CHAR (10) + '<a>' + a  + '</a>' +CHAR (10) + '<b>'+ b  + '</b>' +CHAR (10) + '</food_ratio>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</food_ratio_list>';
--
END IF;
--
SET v_doc = doc;
--
END
/
