CREATE PROCEDURE exportCategoryToXml(
--
IN vFoodCategoryId LONGVARCHAR
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
--
SET doc = '';
SET doc2 = '';
--
SET doc2 = '<foods xmlns:xsi=''http://www.w3.org/2001/XMLSchema-instance''>' + CHAR(10);
------------------------------------------------------------
FOR SELECT a.foodid AS id, a.name, c.foodcategoryid as categoryid, c.name as categoryname FROM food a, categorylink b, foodcategory c WHERE a.foodid = b.foodid AND b.foodcategoryid = c.foodcategoryid AND c.foodcategoryid = vFoodCategoryId DO
--
SET doc = '<food>' +CHAR(10)+'<food-id>'+id +'</food-id>' +CHAR (10) + '<food-name>'+ escape_xml_element_data(name) +'</food-name>' +CHAR (10);
--
SET doc2 = doc2 + doc;
--
FOR SELECT * FROM (SELECT NUTRIENTID, LABEL, UNITS, Q FROM FOODFACT Y,NUTRIENT Z WHERE Y.FOODID = id AND   Y.NUTRIENTID = Z.NUTRIENTID AND   (Y.NUTRIENTID != '10003' AND Y.NUTRIENTID != '10009' AND Y.NUTRIENTID != '10010' AND Y.NUTRIENTID != '10011' AND Y.NUTRIENTID != '10012' AND Y.NUTRIENTID != '10013' AND Y.NUTRIENTID != '10014' AND Y.NUTRIENTID != '10015' AND Y.NUTRIENTID != '10016')) ORDER BY LABEL DO
--
SET doc = '<'+label +' '+'units="'+units+'" '+'nutr_no="'+nutrientid+'" '+'>'+ q +'</'+label +'>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
END FOR;
--
SET doc2 = doc2 + '<category-list>'+ CHAR (10);
--
SET doc = '<category>'+ CHAR (10) + '<category-id>' + categoryid + '</category-id>' + CHAR (10) + '<category-name>' + categoryname + '</category-name>' + CHAR (10) + '</category>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
SET doc2 = doc2 + '</category-list>'+ CHAR (10);
--
SET doc2 = doc2 + '</food>' + CHAR (10);
--
END FOR;
--
SET doc2 = doc2 + '</foods>';
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
