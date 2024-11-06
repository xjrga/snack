CREATE FUNCTION get_polyufat_ratio (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE ratio DOUBLE;
--
SELECT CASEWHEN (SUM(sfa) <= 0,0,SUM(pufa) / SUM(sfa)) INTO ratio FROM mixresultdn WHERE mixid = v_MixId;
--
RETURN ratio;
--
END;
/
