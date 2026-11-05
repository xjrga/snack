CREATE FUNCTION fetchTniScore (
--
IN v_mixid LONGVARCHAR,
IN v_lifestageid INTEGER
--
)
--
RETURNS DECIMAL(28,15) READS SQL DATA BEGIN ATOMIC
--
DECLARE v_tniscore DECIMAL(28,15);
--
SELECT tniscore INTO v_tniscore FROM Mix WHERE MixId =  v_mixid;
--
RETURN v_tniscore;

END;
/