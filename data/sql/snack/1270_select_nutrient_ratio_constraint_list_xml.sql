CREATE PROCEDURE Select_nutrient_ratio_constraint_list_as_xml (
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
SELECT count(nutrient_id_1, nutrient_id_2, relationshipid, a, b) INTO counter FROM nutrientratio WHERE mixid = v_mixid;
--
IF counter > 0 THEN
--
SET doc = doc + '<nutrient_ratio_constraint_list>' + CHAR (10);
--
FOR select nutrient_id_1, nutrient_id_2, relationshipid, a, b from nutrientratio WHERE mixid = v_mixid DO
--
SET doc = doc + '<nutrient_ratio_constraint>' + CHAR (10)  + '<nutrientid>' + nutrient_id_1 + '</nutrientid>' + CHAR (10)  + '<nutrientid>' + nutrient_id_2 + '</nutrientid>' + CHAR (10) + '<relationshipid>' + relationshipid  + '</relationshipid>' + CHAR (10) + '<a>' + cast(a as decimal(128,32))  + '</a>' +CHAR (10) + '<b>'+ cast(b as decimal(128,32))  + '</b>' +CHAR (10) + '</nutrient_ratio_constraint>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</nutrient_ratio_constraint_list>';
--
END IF;
--
SET v_doc = doc;
--
END
/
