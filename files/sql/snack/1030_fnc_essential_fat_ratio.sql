CREATE FUNCTION get_essential_fat_ratio (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE ratio DOUBLE;
--
SELECT CASEWHEN(sum(alphalinolenicacid) <= 0,0,sum(linoleicacid)/sum(alphalinolenicacid)) INTO ratio FROM mixresultdn WHERE mixid = v_MixId;
--
RETURN ratio;
--
END;
/
