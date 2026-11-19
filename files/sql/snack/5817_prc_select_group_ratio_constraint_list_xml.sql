CREATE PROCEDURE Select_group_ratio_constraint_list_as_xml (
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
SELECT count(group_id_1, nutrient_id_1,group_id_2, nutrient_id_2,relationshipid, a, b) INTO counter FROM FoodGroupRatioC WHERE mixid = v_mixid;
--
IF counter > 0 THEN
--
SET doc = doc + '<group_ratio_list>' + CHAR (10);
--
FOR select group_id_1, nutrient_id_1, group_id_2, nutrient_id_2, relationshipid, a, b from FoodGroupRatioC WHERE mixid = v_mixid DO
--
SET doc = doc + '<group_ratio>' + CHAR (10) + '<group-id_a>' + group_id_1 + '</group-id_a>' + CHAR (10) + '<nutrient-id_a>' + nutrient_id_1 + '</nutrient-id_a>' + CHAR (10) + '<group-id_b>' + group_id_2 + '</group-id_b>' + CHAR (10) + '<nutrient-id_b>' + nutrient_id_2 + '</nutrient-id_b>' + CHAR (10) + '<relationship-id>' + relationshipid  + '</relationship-id>' + CHAR (10) + '<a>' + a  + '</a>' +CHAR (10) + '<b>'+ b  + '</b>' +CHAR (10) + '</group_ratio>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</group_ratio_list>';
--
END IF;
--
SET v_doc = doc;
--
END
/
