CREATE PROCEDURE DnMixResult_delete (
--
IN v_MixId LONGVARCHAR
--
)
--
MODIFIES SQL DATA BEGIN ATOMIC
--
delete from DnMixResult where mix_id = v_MixId;
--
END;
/
