CREATE PROCEDURE foodnutrientratio_rhs (
--
IN v_mixid INTEGER
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
       0 AS b
       --foodratio_b1,
       --foodratio_b2
       FROM foodnutrientratio
WHERE mixid = v_mixid
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
