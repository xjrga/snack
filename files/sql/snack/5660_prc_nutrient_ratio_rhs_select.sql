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
       0 AS b
       FROM nutrientratio
WHERE mixid = v_mixid
ORDER BY mixid,
         nutrient_id_1,
         nutrient_id_2,
         relationshipid;
--
OPEN result;
--
END;
/
