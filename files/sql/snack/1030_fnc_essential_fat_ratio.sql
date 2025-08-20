CREATE FUNCTION get_essential_fat_ratio (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE ratio DECIMAL(25, 18);
--
SELECT CASEWHEN(sum(fats_linolenic) <= 0,0,sum(fats_linoleic)/sum(fats_linolenic)) INTO ratio FROM DnMixResult WHERE mix_id = v_MixId;
--
RETURN ratio;
--
END;
/
