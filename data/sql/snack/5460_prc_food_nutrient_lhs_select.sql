CREATE PROCEDURE foodnutrient_lhs (
--
IN v_MixId LONGVARCHAR,
--
IN v_foodid LONGVARCHAR,
--
IN v_nutrientid LONGVARCHAR,
--
IN v_relationshipid INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT food_id_b,
       nutrientid,
       c
FROM (SELECT a.mixid,
       a.foodid as food_id_a,
       a.relationshipid,
       b.foodid as food_id_b,
       a.nutrientid,
       CASE
         WHEN b.foodid = a.foodid THEN (select c from foodfactcoefficient where foodid = a.foodid and nutrientid = a.nutrientid)
         ELSE 0
       END AS c
FROM foodnutrientconstraint a,
     mixfood b
WHERE a.mixid = b.mixid
AND a.mixid = v_mixid
ORDER BY a.mixid,
         a.foodid,
         a.relationshipid,
         b.foodid
)
WHERE mixid = v_mixid
AND   food_id_a = v_foodid
AND   nutrientid = v_nutrientid
AND   relationshipid = v_relationshipid
ORDER BY mixid,
         food_id_a,
         relationshipid,
         food_id_b,
         nutrientid;
--	    
OPEN result;
--
END
/