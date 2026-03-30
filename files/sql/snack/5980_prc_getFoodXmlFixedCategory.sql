CREATE PROCEDURE getFoodXmlFixedCategory(
--
IN v_foodId LONGVARCHAR,
--
IN v_categoryId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1
--
BEGIN ATOMIC
--
DECLARE TABLE temp ( txt LONGVARCHAR);
DECLARE doc LONGVARCHAR;
DECLARE xml LONGVARCHAR;
--
SET doc = '';
SET xml = '';
------------------------------------------------------------
FOR SELECT foodid as id, name FROM food WHERE foodid = v_foodId DO
--
SET doc = '<food>' +CHAR(10)+'<food-id>'+id +'</food-id>' +CHAR (10) + '<food-name>'+ escape_xml_element_data(name) +'</food-name>' +CHAR (10);
--
SET xml = xml + doc;
--
FOR SELECT * FROM (SELECT NUTRIENTID, LABEL, UNITS, Q FROM FOODFACT Y,NUTRIENT Z WHERE Y.FOODID = id AND Y.NUTRIENTID = Z.NUTRIENTID AND Z.CALCULATED = 0) ORDER BY LABEL DO
--
SET doc = '<'+label +' '+'units="'+units+'" '+'nutr_no="'+nutrientid+'" '+'>'+ q +'</'+label +'>' + CHAR (10);
--
SET xml = xml + doc;
--
END FOR;
--
SET xml = xml + '<category-list>'+ CHAR (10);
--
FOR SELECT c.foodcategoryid as categoryid, b.name as categoryname FROM foodcategory b, categorylink c WHERE  b.foodcategoryid = c.foodcategoryid AND c.foodid = id AND b.foodcategoryid = v_categoryId DO
--
SET doc = '<category>'+ CHAR (10) + '<category-id>' + categoryid + '</category-id>' + CHAR (10) + '<category-name>' + categoryname + '</category-name>' + CHAR (10) + '</category>' + CHAR (10);
--
SET xml = xml + doc;
--
END FOR;
--
SET xml = xml + '</category-list>'+ CHAR (10);
--
SET xml = xml + '</food>' + CHAR (10);
--
END FOR;
---------------------------------------------------
INSERT INTO temp (txt) VALUES (xml);
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
