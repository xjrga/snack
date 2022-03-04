CREATE PROCEDURE Mix_getFQDiff (
--
IN v_MixId_1 LONGVARCHAR,
--
IN v_MixId_2 LONGVARCHAR
--
)
--
MODIFIES SQL DATA DYNAMIC RESULT SETS 1 BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT 'Food Quotient' AS nutrient,
       a.fq AS mix1,
       b.fq AS mix2,
       a.fq - b.fq AS diff
FROM (SELECT getFoodQuotient(v_MixId_1) AS fq FROM ( VALUES (0))) a,
     (SELECT getFoodQuotient(v_MixId_2) AS fq FROM ( VALUES (0))) b;
--
OPEN result;
--
END;
/