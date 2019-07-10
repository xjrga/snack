CREATE FUNCTION generateId(
--
IN v_txt_1 VARCHAR(8000),
--
IN v_txt_2 VARCHAR(8000)
--
) RETURNS VARCHAR(8000)
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_id VARCHAR(8000);
--
SELECT v_txt_1||v_txt_2||generateLargeRandomNumber() INTO v_id FROM (VALUES(0));
--
RETURN v_id;
--
END;
/