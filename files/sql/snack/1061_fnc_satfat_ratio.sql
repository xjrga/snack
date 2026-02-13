CREATE FUNCTION get_satfat_ratio (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE ratio DECIMAL(25, 18);
--
SELECT CASEWHEN (SUM(fats_total) <= 0,0,SUM(fats_saturated) / SUM(fats_total)) INTO ratio FROM DnMixResult WHERE mix_id = v_MixId;
--
RETURN ratio;
--
END;
/
