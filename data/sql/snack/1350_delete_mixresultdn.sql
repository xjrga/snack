CREATE PROCEDURE mixresultdn_delete (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
delete from mixresultdn where mixid = v_MixId;
--
END;
/
