CREATE PROCEDURE foodnutrient_rhs (
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
       foodid,
       nutrientid,
       relationshipid,
       b
FROM foodnutrientconstraint
WHERE mixid = v_mixid
ORDER BY foodid;
--
OPEN result;
--
END;
/
