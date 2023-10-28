CREATE FUNCTION get_monoufat_ratio (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE ratio DOUBLE;
--
SELECT CASEWHEN (SUM(sfa) <= 0,0,SUM(mufa) / SUM(sfa)) INTO ratio FROM mixresultdn WHERE mixid = v_MixId;
--
RETURN ratio;
--
END;
/
