CREATE PROCEDURE nutrient_rhs (
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
       nutrientid,
       relationshipid,
       b
FROM nutrientconstraint
WHERE mixid = v_mixid
ORDER BY nutrientid;
--
OPEN result;
--
END;
/
