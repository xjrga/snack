CREATE FUNCTION generateLargeRandomNumber() RETURNS NUMERIC
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_count NUMERIC;
--
SET v_count = round(rand()*10000000000);
--
RETURN v_count;
--
END;
/