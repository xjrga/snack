CREATE PROCEDURE Select_mixfood_list_as_xml (
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
SET doc2 = '<food_list>' + CHAR(10) ;
------------------------------------------------------------
FOR SELECT a.foodid as id ,name FROM mixfood a, food b WHERE a.foodid = b.foodid  AND a.mixid = v_MixId  DO
--
SET doc = '<food>' +CHAR(10)+'<food-id>'+id +'</food-id>' +CHAR (10) + '<food-name>'+ escape_xml_element_data(name) +'</food-name>' +CHAR (10);
--
SET doc2 = doc2 + doc;
--
FOR SELECT * FROM (SELECT LABEL, Q FROM FOODFACT Y,NUTRIENT Z WHERE Y.FOODID = id AND   Y.NUTRIENTID = Z.NUTRIENTID AND   (Y.NUTRIENTID != '10003' AND Y.NUTRIENTID != '10006' AND Y.NUTRIENTID != '10009' AND Y.NUTRIENTID != '10010' AND Y.NUTRIENTID != '10011' AND Y.NUTRIENTID != '10012' AND Y.NUTRIENTID != '10013' AND Y.NUTRIENTID != '10014') UNION SELECT 'carbohydrates-glycemicindex' AS LABEL, pick_food_gi(id) FROM (VALUES(0)) ) ORDER BY LABEL DO
--
SET doc = '<'+label +'>'+cast(q as decimal(128,32)) +'</'+label +'>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
END FOR;
--
SET doc2 = doc2 + '</food>' + CHAR (10);
--
END FOR;
--
SET v_doc = doc2 + '</food_list>';
--
END
/
