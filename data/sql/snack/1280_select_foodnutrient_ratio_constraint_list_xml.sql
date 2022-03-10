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
SELECT count(food_id_1, nutrient_id_1,food_id_2, nutrient_id_2,relationshipid, a, b) INTO counter FROM foodnutrientratio WHERE mixid = v_mixid;
--
IF counter > 0 THEN
--
SET doc = doc + '<food_nutrient_ratio_constraint_list>' + CHAR (10);
--
FOR select food_id_1, nutrient_id_1,food_id_2, nutrient_id_2,relationshipid, a, b from foodnutrientratio WHERE mixid = v_mixid DO
--
SET doc = doc + '<food_nutrient_ratio_constraint>' + CHAR (10) + '<foodid_01>' + food_id_1 + '</foodid_01>' + CHAR (10) + '<nutrientid_01>' + nutrient_id_1 + '</nutrientid_01>' + CHAR (10) + '<foodid_02>' + food_id_2 + '</foodid_02>' + CHAR (10) + '<nutrientid_02>' + nutrient_id_2 + '</nutrientid_02>' + CHAR (10) + '<relationshipid>' + relationshipid  + '</relationshipid>' + CHAR (10) + '<a>' + cast(a as decimal(128,32))  + '</a>' +CHAR (10) + '<b>'+ cast(b as decimal(128,32))  + '</b>' +CHAR (10) + '</food_nutrient_ratio_constraint>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</food_nutrient_ratio_constraint_list>';
--
END IF;
--
SET v_doc = doc;
--
END
/
