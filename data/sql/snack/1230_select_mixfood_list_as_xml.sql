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
DECLARE v_gi DOUBLE;
--
SET doc = '';
SET doc2 = '';
--
SET doc2 = '<food_list>' + CHAR(10) ;
------------------------------------------------------------
FOR SELECT a.foodid as id ,name FROM mixfood a, food b WHERE a.foodid = b.foodid  AND a.mixid = v_MixId  DO
--
SET doc = '<food>' +CHAR(10)+'<foodid>'+id +'</foodid>' +CHAR (10) + '<name>'+ escape_xml_element_data(name) +'</name>' +CHAR (10);
--
SET doc2 = doc2 + doc;
--
FOR SELECT label, nutrientid, q FROM mixfood x,  foodfact y, nutrient z WHERE x.foodid = y.foodid AND y.nutrientid = z.nutrientid AND x.mixid = v_MixId AND x.foodid = id AND (y.nutrientid != '10003' AND y.nutrientid != '10006' AND y.nutrientid != '10009' AND y.nutrientid != '10010' AND y.nutrientid != '10011' AND y.nutrientid != '10012' AND y.nutrientid != '10013' AND y.nutrientid != '10014') ORDER BY foodid, label DO
--
SET doc = '<'+label +'>'+cast(q as decimal(128,32)) +'</'+label +'>' +CHAR (10);
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
SET doc2 = doc2 + '<glycemicindex>'+cast(v_gi as decimal(128,32)) +'</glycemicindex>' +CHAR (10);
--
SET doc2 = doc2 + '</food>' + CHAR (10);
--
END FOR;
--
SET v_doc = doc2 + '</food_list>';
--
END
/
