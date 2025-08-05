CREATE FUNCTION get_monoufat_ratio (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE ratio DECIMAL(24,18);
--
SELECT CASEWHEN (SUM(fats_saturated) <= 0,0,SUM(fats_monounsaturated) / SUM(fats_saturated)) INTO ratio FROM DnMixResult WHERE mix_id = v_MixId;
--
RETURN ratio;
--
END;
/
