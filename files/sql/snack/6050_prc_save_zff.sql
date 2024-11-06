CREATE PROCEDURE save_zff(
IN v_mixid LONGVARCHAR
)
MODIFIES SQL DATA
BEGIN ATOMIC
--
DELETE FROM ZFF WHERE mixid = v_mixid;
--
CALL populate_zff(v_mixid);
--
END;
/