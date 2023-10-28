CREATE FUNCTION get_electrolyte_ratio (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE ratio DOUBLE;
--
SELECT CASEWHEN(sum(sodium) <= 0,0,sum(potassium)/sum(sodium)) INTO ratio FROM mixresultdn WHERE mixid = v_MixId;
--
RETURN ratio;
--
END;
/
