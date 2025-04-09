CREATE PROCEDURE Select_nutrient_constraint_list_as_xml (
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
SELECT count(nutrientid, relationshipid, b) INTO counter FROM nutrientconstraint WHERE mixid = v_mixid;
--
IF counter > 0 THEN
--
SET doc = doc + '<nutrient_quantity_list>' + CHAR (10);
--
FOR select nutrientid, relationshipid, b from nutrientconstraint  WHERE mixid = v_mixid DO
--
SET doc = doc + '<nutrient_quantity>' + CHAR (10) + '<nutrient-id>' + nutrientid + '</nutrient-id>' + CHAR (10) + '<relationship-id>'+relationshipid +'</relationship-id>' + CHAR (10) + '<b>'+ b +'</b>' + CHAR (10) + '</nutrient_quantity>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</nutrient_quantity_list>';
--
END IF;
--
SET v_doc = doc;
--
END
/