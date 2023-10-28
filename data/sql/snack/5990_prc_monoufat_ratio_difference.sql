CREATE PROCEDURE get_monoufat_ratio_difference (
--
IN v_MixId_1 LONGVARCHAR,
IN v_MixId_2 LONGVARCHAR,
IN v_Precision INTEGER
--
)
--
MODIFIES SQL DATA
DYNAMIC RESULT SETS 1
BEGIN ATOMIC
--
DECLARE result CURSOR
FOR
SELECT 'Ratio MUFA/SFA' AS nutrient,
       ROUND(a.ratio,v_Precision) AS mix1,
       ROUND(b.ratio,v_Precision) AS mix2,
       ROUND(b.ratio - a.ratio,v_Precision) AS diff
FROM (SELECT get_monoufat_ratio(v_MixId_1) AS ratio FROM ( VALUES (0))) a,
     (SELECT get_monoufat_ratio(v_MixId_2) AS ratio FROM ( VALUES (0))) b;
--
OPEN result;
--
END;
/