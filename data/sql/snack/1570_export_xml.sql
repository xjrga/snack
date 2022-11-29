CREATE PROCEDURE Export_xml (IN v_MixId LONGVARCHAR)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC 
--
DECLARE TABLE temp ( txt LONGVARCHAR);
DECLARE doc LONGVARCHAR;
DECLARE doc2 LONGVARCHAR;
--
SET doc = '';
SET doc2 = '<snack' + CHAR(10) + 'xmlns:xsi=''http://www.w3.org/2001/XMLSchema-instance''' + CHAR(10) + 'xsi:noNamespaceSchemaLocation=''https://xjrga.github.io/schemas/snack.xsd''>' + CHAR (10);
--
call Select_mix_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_mixfood_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_category_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_category_link_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_nutrient_constraint_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_foodnutrient_constraint_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2  + doc;
--
call Select_foodnutrient_ratio_constraint_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_nutrient_ratio_constraint_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2 + doc;
--
call Select_nutrient_percent_constraint_list_as_xml (doc,v_MixId);
--
SET doc2 = doc2  + doc;
--
call Select_meal_as_xml (doc,v_MixId);
--
SET doc2 = doc2  + doc;
--
call Select_meal_food_portion_as_xml (doc,v_MixId);
--
SET doc2 = doc2  + doc;
--
SET doc2 = doc2 + CHAR(10) + '</snack>';
--
INSERT INTO temp (txt) VALUES (doc2);
--
BEGIN ATOMIC 
--
DECLARE result CURSOR
FOR
SELECT *
FROM temp;
--
OPEN result;
--
END;
--
END
/
