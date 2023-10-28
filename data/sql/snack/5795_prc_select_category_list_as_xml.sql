CREATE PROCEDURE Select_category_list_as_xml (
--
OUT v_doc LONGVARCHAR,
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC
--
DECLARE doc LONGVARCHAR;
DECLARE doc2 LONGVARCHAR;
--
SET doc = '';
SET doc2 = '';
--
SELECT '<category_list>' INTO doc FROM (VALUES (0));
--
SET doc2 = doc2 + doc + CHAR(10) ;
--
SET doc = '';
--
FOR SELECT DISTINCT c.foodcategoryid as id, c.name as name FROM mixfood a, categorylink b, foodcategory c WHERE a.foodid = b.foodid AND   b.foodcategoryid = c.foodcategoryid AND a.mixid = v_MixId  DO
--
SET doc = '<category>' + CHAR(10) + '<categoryid>' + id + '</categoryid>' + CHAR(10) + '<categoryname>' + escape_xml_element_data(name) + '</categoryname>'  + CHAR(10)  + '</category>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
END FOR;
--
SET doc = '</category_list>';
--
SET v_doc = doc2 + doc;
--
END
/
