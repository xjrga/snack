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
SELECT '<food_list>' INTO doc FROM (VALUES (0));
--
SET doc2 = doc2 + doc + CHAR(10) ;
--
SET doc = '';
------------------------------------------------------------
FOR SELECT a.foodid as id ,name FROM mixfood a, food b WHERE a.foodid = b.foodid  AND a.mixid = v_MixId  DO 
--
SET doc = doc + '<food>' +CHAR(10)+'<foodid>'+id +'</foodid>' +CHAR (10) + '<name>'+name +'</name>' +CHAR (10);
--
SET doc2 = doc2 + doc;
--
SET doc = '';
--
FOR SELECT label, nutrientid, q FROM mixfood x,  foodfact y, nutrient z WHERE x.foodid = y.foodid AND y.nutrientid = z.nutrientid AND   x.mixid = v_MixId AND x.foodid = id AND y.nutrientid != '675' AND  y.nutrientid != '851' ORDER BY foodid, label DO
--
SET doc = doc + '<'+label +'>'+cast(q as decimal(128,32)) +'</'+label +'>' +CHAR (10);
--
END FOR;
--
SET doc2 = doc2 + doc;
--
SET doc = '</food>' + CHAR (10);
--
SET doc2 = doc2 + doc;
--
SET doc = '';
--
END FOR;
--
SET doc = '</food_list>';
--
SET v_doc = doc2 + doc;
--
END
/
