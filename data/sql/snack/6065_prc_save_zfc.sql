CREATE PROCEDURE save_zfc(
IN v_mixid LONGVARCHAR
)
MODIFIES SQL DATA
BEGIN ATOMIC
--
DELETE FROM ZFC WHERE mixid = v_mixid;
--
CALL populate_zfc(v_mixid);
--
END;
/