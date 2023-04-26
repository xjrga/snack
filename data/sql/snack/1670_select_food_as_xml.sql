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
SET doc2 = '<food' + CHAR(10) + 'xmlns:xsi=''http://www.w3.org/2001/XMLSchema-instance''' + CHAR(10) + 'xsi:noNamespaceSchemaLocation=''https://xjrga.github.io/schemas/food.xsd''>' + CHAR (10);
--
FOR SELECT foodid as id ,name FROM food WHERE  foodid  = v_FoodId DO
--
SET doc = '<foodid>'+id +'</foodid>' + CHAR (10) + '<name>'+name +'</name>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
FOR SELECT label, nutrientid, q FROM foodfact y, nutrient z WHERE y.foodid = v_FoodId AND y.nutrientid = z.nutrientid  AND (y.nutrientid != '10003' AND y.nutrientid != '10006' AND y.nutrientid != '10009' AND y.nutrientid != '10010' AND y.nutrientid != '10011' AND y.nutrientid != '10012' AND y.nutrientid != '10013' AND y.nutrientid != '10014') ORDER BY foodid, label DO
--
SET doc = '<'+label +'>'+cast(q as decimal(128,32)) +'</'+label +'>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
END FOR;
--
IF (SELECT COUNT(q) FROM glycemicindex WHERE foodid = id) = 0 THEN
--
SET v_gi = 0;
--
ELSE
--
SELECT CASE WHEN q IS NULL THEN 0 ELSE q END INTO v_gi FROM glycemicindex WHERE foodid = id;
--
END IF;
--
SET doc2 = doc2 + '<glycemicindex>'+cast(v_gi as decimal(128,32)) +'</glycemicindex>' + CHAR (10);
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
