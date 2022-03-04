CREATE FUNCTION generateLargeRandomNumber() RETURNS NUMERIC
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_count NUMERIC;
--
SELECT substring(replace(replace('' + rand () + '' + rand () + '' + rand () + '' + rand () + '' + rand () + '' + rand () + '' + rand () + rand (),'.',''),'E',''),0,129) INTO v_count FROM (VALUES (0));
--
RETURN v_count;
--
END;
/