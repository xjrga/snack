CREATE PROCEDURE Select_foodnutrient_constraint_list_as_xml (
--
OUT v_doc LONGVARCHAR,
--
IN v_mixid LONGVARCHAR
--
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
SELECT count(foodid , nutrientid, relationshipid, b) INTO counter FROM foodnutrientconstraint a WHERE a.mixid = v_mixid;
--
IF counter > 0 THEN
--
SET doc = doc + '<food_nutrient_constraint_list>' + CHAR (10);
--
FOR select foodid , nutrientid, relationshipid, b from foodnutrientconstraint a WHERE a.mixid = v_mixid DO
--
SET doc = doc + '<food_nutrient_constraint>' + CHAR (10) + '<foodid>' + foodid + '</foodid>' + CHAR (10) + '<nutrientid>' + nutrientid + '</nutrientid>' + CHAR (10) + '<relationshipid>'+relationshipid +'</relationshipid>' + CHAR (10) + '<b>'+ cast(b as decimal(128,32)) +'</b>' + CHAR (10) + '</food_nutrient_constraint>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</food_nutrient_constraint_list>';
--
END IF;
--
SET v_doc = doc;
--
END
/
