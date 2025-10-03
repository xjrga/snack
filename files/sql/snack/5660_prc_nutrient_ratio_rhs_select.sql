CREATE PROCEDURE nutrientratio_rhs (
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
       nutrient_id_1,
       nutrient_id_2,
       relationshipid,
       a,
       b,       
       b.name as nutrient1,
       c.name as nutrient2,
       d.name as eq
FROM NutrientRatioC a, nutrient b, nutrient c, relationship d
WHERE mixid = v_mixid
AND a.nutrient_id_1 = b.nutrientid
AND a.nutrient_id_2 = c.nutrientid
AND a.relationshipid = d.relationshipid
ORDER BY mixid,
         nutrient_id_1,
         nutrient_id_2,
         relationshipid;
--
OPEN result;
--
END;
/
