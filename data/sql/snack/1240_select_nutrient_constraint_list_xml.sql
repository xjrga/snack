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
SET doc = doc + '<nutrient_constraint_list>' + CHAR (10);
--
FOR select nutrientid, relationshipid, b from nutrientconstraint  WHERE mixid = v_mixid DO
--
SET doc = doc + '<nutrient_constraint>' + CHAR (10) + '<nutrientid>' + nutrientid + '</nutrientid>' + CHAR (10) + '<relationshipid>'+relationshipid +'</relationshipid>' + CHAR (10) + '<b>'+ cast(b as decimal(128,32)) +'</b>' + CHAR (10) + '</nutrient_constraint>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</nutrient_constraint_list>';
--
END IF;
--
SET v_doc = doc;
--
END
/