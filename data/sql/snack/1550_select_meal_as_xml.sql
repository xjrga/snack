CREATE PROCEDURE Select_meal_as_xml (
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
SET doc = CHAR(10) + '<meal_list>' + CHAR(10);
--
FOR SELECT mixid, mealid, name, mealorder FROM meal WHERE mixid = v_MixId ORDER BY mealorder DO
--
SET doc = doc +  '<meal>' + CHAR(10) + '<mixid>' + mixid + '</mixid>' + CHAR(10)  + '<mealid>' + mealid + '</mealid>' + CHAR(10) + '<name>' + escape_xml_element_data(name) + '</name>' + CHAR(10)  + '<mealorder>'  + mealorder + '</mealorder>' + CHAR(10) + '</meal>' + CHAR (10);
--
END FOR;
--
SET doc = doc + '</meal_list>';
--
SET v_doc = doc;
--
END
/
