CREATE PROCEDURE Select_food_as_xml (
--
IN v_FoodId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC
--
DECLARE TABLE temp ( txt LONGVARCHAR);
DECLARE doc LONGVARCHAR;
DECLARE doc2 LONGVARCHAR;
DECLARE v_gi DOUBLE;
--
SET doc = '';
SET doc2 = '<food' + CHAR(10) + 'xmlns:xsi=''http://www.w3.org/2001/XMLSchema-instance''' + CHAR(10) + 'xsi:noNamespaceSchemaLocation=''https://xjrga.github.io/schemas/food_v2.xsd''>' + CHAR (10);
--
FOR SELECT foodid as id ,name FROM food WHERE  foodid  = v_FoodId DO
--
SET doc = '<food-id>'+id +'</food-id>' + CHAR (10) + '<food-name>'+ escape_xml_element_data(name) +'</food-name>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
FOR SELECT * FROM (SELECT LABEL, Q FROM FOODFACT Y,NUTRIENT Z WHERE Y.FOODID = v_FoodId AND   Y.NUTRIENTID = Z.NUTRIENTID AND   (Y.NUTRIENTID != '10003' AND Y.NUTRIENTID != '10006' AND Y.NUTRIENTID != '10009' AND Y.NUTRIENTID != '10010' AND Y.NUTRIENTID != '10011' AND Y.NUTRIENTID != '10012' AND Y.NUTRIENTID != '10013' AND Y.NUTRIENTID != '10014' AND Y.NUTRIENTID != '10015') UNION SELECT 'carbohydrates-glycemicindex' AS LABEL, pick_food_gi(v_FoodId) FROM (VALUES(0)) ) ORDER BY LABEL DO
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
