CREATE FUNCTION get_electrolyte_ratio (IN v_MixId LONGVARCHAR) RETURNS DOUBLE
--
READS SQL DATA
BEGIN ATOMIC
--
DECLARE ratio DECIMAL(10,5);
--
SELECT CASEWHEN(sum(minerals_sodium) <= 0,0,sum(minerals_potassium)/sum(minerals_sodium)) INTO ratio FROM DnMixResult WHERE mix_id = v_MixId;
--
RETURN ratio;
--
END;
/
