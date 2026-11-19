CREATE PROCEDURE groupratio_rhs (
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
       group_id_1,
       nutrient_id_1,
       group_id_2,
       nutrient_id_2,
       relationshipid,
       a,
       b,
       b.name as group1,
       c.name as nutrient1,
       d.name as group2,
       e.name as nutrient2,
       f.name as eq
FROM FoodGroupRatioC a, mixfoodgroup b, nutrient c, mixfoodgroup d, nutrient e, relationship f
WHERE mixid = v_mixid
AND a.group_id_1 = b.groupid
AND a.nutrient_id_1 = c.nutrientid
AND a.group_id_2 = d.groupid
AND a.nutrient_id_2 = e.nutrientid
AND a.relationshipid = f.relationshipid
ORDER BY mixid,
         group_id_1,
         nutrient_id_1,
         group_id_2,
         nutrient_id_2;
--
OPEN result;
--
END;
/
