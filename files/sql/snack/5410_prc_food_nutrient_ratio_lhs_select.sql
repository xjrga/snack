CREATE PROCEDURE foodnutrientratio_lhs (
--
IN v_MixId LONGVARCHAR,
--
IN v_foodid1 LONGVARCHAR,
--
IN v_nutrientid1 LONGVARCHAR,
--
IN v_foodid2 LONGVARCHAR,
--
IN v_nutrientid2 LONGVARCHAR,
--
IN v_relationshipid INTEGER
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT foodid,
       c
FROM (SELECT a.mixid,
       a.food_id_1,
       a.nutrient_id_1,
       a.food_id_2,
       a.nutrient_id_2,
       a.relationshipid,
       b.foodid,
       CASE
         WHEN b.foodid = a.food_id_1 THEN (select c from foodfactcoefficient where foodid = a.food_id_1 and nutrientid = a.nutrient_id_1)
         ELSE 0
       END * a.b - CASE
         WHEN b.foodid = a.food_id_2 THEN (select c from foodfactcoefficient where foodid = a.food_id_2 and nutrientid = a.nutrient_id_2)
         ELSE 0
       END * a.a AS c
FROM FoodRatioC a,
     mixfood b
WHERE a.mixid = b.mixid
AND mixid = v_mixid
AND   a.food_id_1 = v_foodid1
AND   a.nutrient_id_1 = v_nutrientid1
AND   a.food_id_2 = v_foodid2
AND   a.nutrient_id_2 = v_nutrientid2
AND   a.relationshipid = v_relationshipid
ORDER BY mixid,
         food_id_1,
         nutrient_id_1,
         food_id_2,
         nutrient_id_2,
         relationshipid,
         foodid
);
--	    
OPEN result;
--
END;
/
