CREATE PROCEDURE foodnutrientratio_rhs (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT mixid,
       food_id_1,
       nutrient_id_1,
       food_id_2,
       nutrient_id_2,
       relationshipid,
       a,
       b,
       b.name as food1,
       c.name as nutrient1,
       d.name as food2,
       e.name as nutrient2,
       f.name as eq
FROM FoodRatioC a, food b, nutrient c, food d, nutrient e, relationship f
WHERE mixid = v_mixid
AND a.food_id_1 = b.foodid
AND a.nutrient_id_1 = c.nutrientid
AND a.food_id_2 = d.foodid
AND a.nutrient_id_2 = e.nutrientid
AND a.relationshipid = f.relationshipid
ORDER BY mixid,
         food_id_1,
         nutrient_id_1,
         food_id_2,
         nutrient_id_2;
--
OPEN result;
--
END;
/
