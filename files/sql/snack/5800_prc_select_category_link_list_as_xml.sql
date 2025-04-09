CREATE PROCEDURE Select_category_link_list_as_xml (
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
SELECT '<category_link_list>' INTO doc FROM (VALUES (0));
--
SET doc2 = doc2 + doc + CHAR(10) ;
--
SET doc = '';
--
FOR select a.foodid as foodid, a.foodcategoryid as categoryid from categorylink a, mixfood b where a.foodid = b.foodid and b.mixid = v_MixId  DO 
--
SET doc =  '<category_link>' + CHAR(10) + '<food-id>' + foodid + '</food-id>' + CHAR(10) + '<category-id>' + categoryid + '</category-id>'  + CHAR(10) + '</category_link>'  + CHAR(10) ;
--
SET doc2 = doc2 + doc;
--
END FOR;
--
SET doc = '</category_link_list>';
--
SET v_doc = doc2 + doc;
--
END
/