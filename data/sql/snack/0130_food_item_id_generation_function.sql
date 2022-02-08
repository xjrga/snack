CREATE FUNCTION generateId(
--
IN v_txt_1 LONGVARCHAR,
--
IN v_txt_2 LONGVARCHAR
--
) RETURNS LONGVARCHAR
--
READS SQL DATA BEGIN ATOMIC
--
DECLARE v_id LONGVARCHAR;
--
SELECT v_txt_1||v_txt_2||generateLargeRandomNumber() INTO v_id FROM (VALUES(0));
--
RETURN v_id;
--
END;
/